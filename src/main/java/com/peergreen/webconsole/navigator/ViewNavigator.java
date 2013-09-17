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

package com.peergreen.webconsole.navigator;

import com.vaadin.ui.Component;

/**
 * Vaadin view navigator
 *
 * @author Mohammed Boukada
 */
public interface ViewNavigator {
    /**
     * Navigate to the given path
     *
     * @param path path to extension
     */
    void navigateTo(String path);

    /**
     * Register an extension as navigable
     *
     * @param extension      extension object
     * @param navigableModel extension's navigable model
     */
    void registerNavigableModel(Component extension, NavigableModel navigableModel);

    /**
     * Unregister an extension
     *
     * @param extension extension object
     */
    void unregisterNavigableModel(Component extension);

    /**
     * Get the location of an extension
     *
     * @param extension wanted extension. <br/>
     *                  This parameter could be the extension class name or one of its own extension point.
     * @return path to the extension
     */
    String getLocation(String extension);

    /**
     * Get the navigable model of an extension
     *
     * @param extension wanted extension. <br />
     *                  This parameter could be the extension class name or one of its own extension point.
     * @return extension's navigable model
     */
    NavigableModel getNavigableModel(String extension);
}
