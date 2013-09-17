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

package com.peergreen.webconsole;

import com.peergreen.webconsole.navigator.ViewNavigator;
import com.vaadin.ui.UI;

/**
 * UI context
 *
 * @author Mohammed Boukada
 */
public interface UIContext {

    /**
     * Get Web Console security manager
     *
     * @return security manager
     */
    ISecurityManager getSecurityManager();

    /**
     * Get Vaadin UI
     *
     * @return Vaadin UI
     */
    UI getUI();

    /**
     * Get Vaadin view navigator
     *
     * @return view navigator
     */
    ViewNavigator getViewNavigator();

    /**
     * Get UI id
     *
     * @return UI id
     */
    String getUIId();
}
