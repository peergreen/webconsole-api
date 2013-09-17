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

package com.peergreen.webconsole.resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Css contribution service
 *
 * @author Mohammed Boukada
 */
public interface CssInjectorService {
    /**
     * Inject css
     *
     * @param is css input stream
     * @return Css handler
     * @throws IOException
     */
    CssHandle inject(InputStream is) throws IOException;

    /**
     * Inject css
     *
     * @param cssContent css content
     * @return css handler
     */
    CssHandle inject(String cssContent);
}
