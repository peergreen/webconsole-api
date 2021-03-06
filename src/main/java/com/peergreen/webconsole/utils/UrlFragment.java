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

package com.peergreen.webconsole.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mohammed Boukada
 */
public final class UrlFragment {

    private static Pattern p = Pattern.compile("(/([^/]*))(/([^/]*))*");

    private UrlFragment() {
        // Prevent instantiation
    }

    /**
     * Take a URL string and return the first fragment
     * Example <br/>
     * - Input : /frag1/frag2/frag3
     * - return : /frag1
     *
     * @param s
     * @return
     */
    public static String getFirstFragment(String s) {
        Matcher m = p.matcher(s);
        if (m.matches()) {
            return m.group(1);
        }
        return s;
    }

    /**
     * Take a URL string and sub the first fragment
     * Example <br/>
     * - Input : /frag1/frag2/frag3
     * - return : /frag2/frag3
     *
     * @param s
     * @return
     */
    public static String subFirstFragment(String s) {
        Matcher m = p.matcher(s);
        if (m.matches()) {
            return s.substring(m.group(1).length());
        }
        return s;
    }
}
