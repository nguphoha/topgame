/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.controller.router;

import com.ocpsoft.pretty.PrettyContext;
import inet.controller.BaseController;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author TUTL
 */
@ManagedBean
public class ProfileRouter extends BaseController {

//    private String id;
//    private String code;

    @Override
    public String routing() {
        if (isMobile) {
            return "/wap/profile/index.xhtml";
        } else {
            return "/web/profile/index.xhtml";
        }

    }    

}
