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

import java.io.File;

/**
 * @author Mohammed Boukada
 */
public interface Constants {
    String CONSOLE_ID = "console.id";
    String CONSOLE_NAME = "console.name";
    String CONSOLE_ALIAS = "console.alias";
    String CONSOLE_DOMAINS = "console.domains";
    String ENABLE_SECURITY = "enable.security";
    String DEFAULT_ROLES = "default.roles";

    String SCOPE_EXTENSION_POINT = "com.peergreen.webconsole.scope";

    String PRODUCTION_MODE_CONSOLE_PID = "com.peergreen.webconsole.production";
    String DEVELOPMENT_MODE_CONSOLE_PID = "com.peergreen.webconsole.development";

    String WEBCONSOLE_EXTENSION = "webconsole.extension";
    String EXTENSION_POINT = "extension.point";
    String EXTENSION_ROLES = "extension.roles";
    String EXTENSION_ALIAS = "extension.alias";

    String UI_ID = "ui.id";
    String UI_CONTEXT = "ui.context";

    String REQUIRES_FILTER = "requires.filters";

    String STORAGE_DIRECTORY = System.getProperty("user.dir") + File.separator + "peergreen" + File.separator + "storage" + File.separator + "webconsole" + File.separator;
}
