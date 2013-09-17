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

import java.util.Map;

/**
 * Navigation context
 *
 * @author Mohammed Boukada
 */
public interface NavigationContext {

    /**
     * Get current path
     *
     * @return current path
     */
    String getPath();

    /**
     * Set path
     *
     * @param path path
     */
    void setPath(String path);

    /**
     * Get navigation properties
     *
     * @return navigation properties
     */
    Map<String, Object> getProperties();
}
