/**  
 * @Title:  DetallePlanRepository.java   
 * @Package co.edu.usbcali.viajesusb.repository   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   16/10/2021 8:45:09 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajesusb.domain.DetallePlan;

/**   
 * @ClassName:  DetallePlanRepository   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   16/10/2021 8:45:09 a. m.      
 * @Copyright:  USB
 */

public interface DetallePlanRepository extends JpaRepository<DetallePlan, Long>{

}
