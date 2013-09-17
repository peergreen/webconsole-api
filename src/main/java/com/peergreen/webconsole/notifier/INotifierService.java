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

package com.peergreen.webconsole.notifier;

import com.peergreen.webconsole.HelpOverlay;

/**
 * Notifier service
 *
 * @author Mohammed Boukada
 */
public interface INotifierService {

    /**
     * Add an overlay
     *
     * @param caption
     * @param text
     * @return
     */
    HelpOverlay createHelpOverlay(String caption, String text);

    /**
     * Close all overlays
     */
    void closeAll();

    /**
     * Add a notification
     *
     * @param notification notification message
     */
    void addNotification(String notification);

    /**
     * Create task
     * @param message task message
     * @return task handle
     */
    Task createTask(String message);
}
