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

import com.peergreen.webconsole.notifier.INotifierService;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

/**
 * Default close tab listener
 *
 * @author Mohammed Boukada
 */
public class CloseTabListener implements TabSheet.CloseHandler {

    private INotifierService notifierService;

    public CloseTabListener(INotifierService notifierService) {
        this.notifierService = notifierService;
    }

    @Override
    public void onTabClose(TabSheet tabsheet, Component tabContent) {
        notifierService.addNotification("Warning ! You have closed " +
                tabsheet.getTab(tabContent).getCaption() + " tab");
        tabsheet.removeComponent(tabContent);
    }
}
