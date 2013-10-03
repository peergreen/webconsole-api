/**
 * Peergreen S.A.S. All rights reserved.
 * Proprietary and confidential.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.peergreen.webconsole.vaadin.tabs;

import javax.annotation.PostConstruct;
import java.util.Dictionary;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.peergreen.webconsole.Constants;
import com.peergreen.webconsole.Inject;
import com.peergreen.webconsole.Link;
import com.peergreen.webconsole.UIContext;
import com.peergreen.webconsole.Unlink;
import com.peergreen.webconsole.notifier.INotifierService;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

/**
 * Scope tabs based implementation
 *
 * @author Mohammed Boukada
 */
public abstract class TabScope extends TabSheet {

    private DefaultTab defaultTab = new DefaultTab(this);
    private Map<String, Component> components = new ConcurrentHashMap<>();
    private String name;
    private boolean navigable;
    private SelectedTabListener selectedTabListener;
    private UIContext uiContext;

    protected TabScope(String name, boolean navigable) {
        this.name = name;
        this.navigable = navigable;
    }

    @Inject
    public void setUiContext(UIContext uiContext) {
        this.uiContext = uiContext;
        if (this.navigable) {
            selectedTabListener = new SelectedTabListener(uiContext.getViewNavigator());
            selectedTabListener.addLocation(defaultTab, uiContext.getViewNavigator().getLocation(this.getClass().getName()));
            addSelectedTabChangeListener(selectedTabListener);
        }
    }

    @Inject
    public void setNotifierService(INotifierService notifierService) {
        setCloseHandler(new CloseTabListener(notifierService));
    }

    /**
     * Tab Scope initialization
     */
    @PostConstruct
    public void init() {
        setSizeFull();
        defaultTab.setUi(uiContext.getUI());
        addTab(defaultTab, name, null, 0);
    }

    /**
     * Add extension tab
     *
     * @param tab        extension
     * @param properties extension properties
     */
    @Link("tab")
    public void addTabs(Component tab, Dictionary properties) {
        tab.setSizeFull();
        String tabName = (String) properties.get("tab.value");
        String imgLocation = (String) properties.get("tab.imgPath");

        addTab(tab, tabName).setClosable(true);
        if (imgLocation != null && !"".equals(imgLocation)) {
            defaultTab.addExtension(tab, tabName, new ClassResource(tab.getClass(), imgLocation));
        } else {
            defaultTab.addExtension(tab, tabName);
        }

        String alias = (String) properties.get(Constants.EXTENSION_ALIAS);
        if (alias != null) {
            if (navigable) {
                selectedTabListener.addLocation(tab, uiContext.getViewNavigator().getLocation(tab.getClass().getName()));
            }
            components.put(alias, tab);
        }
    }

    /**
     * Remove extension tab
     *
     * @param tab        extension
     * @param properties extension properties
     */
    @Unlink("tab")
    public void removeTabs(Component tab, Dictionary properties) {
        removeComponent(tab);
        defaultTab.removeExtension((String) properties.get("tab.value"));
        String alias = (String) properties.get(Constants.EXTENSION_ALIAS);
        if (alias != null && components.containsKey(alias)) {
            if (navigable) {
                selectedTabListener.removeLocation(tab);
            }
            components.remove(alias);
        }
    }

    /**
     * Get tabs
     *
     * @return map of component and its alias
     */
    protected Map<String, Component> getComponents() {
        return components;
    }
}
