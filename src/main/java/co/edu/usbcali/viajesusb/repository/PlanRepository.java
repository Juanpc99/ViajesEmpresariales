/**  
 * @Title:  PlanRepository.java   
 * @Package co.edu.usbcali.viajesusb.repository   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   16/10/2021 8:45:21 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajesusb.domain.Plan;

/**   
 * @ClassName:  PlanRepository   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   16/10/2021 8:45:21 a. m.      
 * @Copyright:  USB
 */

public interface PlanRepository extends JpaRepository<Plan, Long>{

}
