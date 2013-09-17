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

import java.lang.reflect.Method;

/**
 * Navigable extension descriptor <br />
 * An {@link com.peergreen.webconsole.Extension} is navigable if it
 * is annotated with {@link com.peergreen.webconsole.navigator.Navigable}
 *
 * @author Mohammed Boukada
 */
public class NavigableModel {

    private NavigableModel parent;
    private String alias;
    private Object extension;
    private Method callbackMethod;

    /**
     * Create a navigable model
     *
     * @param parent    parent navigable model
     * @param alias     extension alias
     * @param extension extension object
     * @param method    called method to navigate
     */
    public NavigableModel(NavigableModel parent, String alias, Object extension, Method method) {
        this.parent = parent;
        this.alias = alias;
        this.extension = extension;
        this.callbackMethod = method;

    }

    /**
     * Get navigable extension
     *
     * @return navigable extension
     */
    public Object getExtension() {
        return extension;
    }

    /**
     * Get the method to call to navigate through the extension <br/>
     * This method should annotated with {@link com.peergreen.webconsole.navigator.Navigate}
     *
     * @return called method to navigate
     */
    public Method getCallbackMethod() {
        return callbackMethod;
    }

    /**
     * Get the full path, including parent(s) alias, to the navigable extension
     *
     * @return full path
     */
    public String getFullPath() {
        if (parent != null) {
            return parent.getFullPath() + alias;
        } else {
            return alias;
        }
    }
}
