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

/**
 * Css contribution handle
 *
 * @author Mohammed Boukada
 */
public interface CssHandle {
    /**
     * Get css content
     *
     * @return css content
     */
    String get();

    /**
     * Update css content
     *
     * @param cssContent new css content
     */
    void update(String cssContent);

    /**
     * Remove css contribution
     */
    void remove();
}
