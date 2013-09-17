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

package com.peergreen.webconsole.vaadin;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * Default Vaadin window component
 *
 * @author Mohammed Boukada
 */
public class DefaultWindow extends Window {

    /**
     * Create a default window
     * @param caption window caption
     * @param content window content. Vaadin component
     * @param footerButtons list of buttons in footer
     */
    public DefaultWindow(String caption, Component content, Button... footerButtons) {
        setCaption(caption);
        setClosable(false);
        setResizable(false);
        addStyleName("edit-dashboard");

        VerticalLayout main = new VerticalLayout();
        main.setSpacing(true);
        main.setMargin(true);
        main.setStyleName("default-window");

        content.addStyleName("default-window-content");
        main.addComponent(content);

        HorizontalLayout footer = new HorizontalLayout();
        footer.setStyleName("footer");
        footer.setWidth("100%");
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        buttons.setMargin(true);

        for (Button button : footerButtons) {
            buttons.addComponent(button);
        }
        footer.addComponent(buttons);
        footer.setComponentAlignment(buttons, Alignment.MIDDLE_RIGHT);

        main.addComponent(footer);
        setContent(main);
    }
}
