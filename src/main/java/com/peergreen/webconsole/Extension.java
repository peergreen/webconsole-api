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

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.HandlerDeclaration;
import org.apache.felix.ipojo.annotations.Stereotype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author Mohammed Boukada
 */
@Component
@HandlerDeclaration("<ns:extension xmlns:ns='com.peergreen.webconsole' />")
@Stereotype
@Target(ElementType.TYPE)
public @interface Extension {
}
