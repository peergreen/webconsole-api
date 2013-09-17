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

import java.util.List;

/**
 * Web console security manager
 *
 * @author Mohammed Boukada
 */
public interface ISecurityManager {

    /**
     * Whether the logged in user has the role
     *
     * @param role given role
     * @return True is user has the given role, false otherwise.
     */
    boolean isUserInRole(String role);

    /**
     * Whether the logged in user has the roles
     *
     * @param roles given roles
     * @return True is user the given roles, false otherwise.
     */
    boolean isUserInRoles(List<String> roles);

    /**
     * Get logged in user name
     *
     * @return user name
     */
    String getUserName();

    // FIXME useless?
    boolean isUserLogged();
}
