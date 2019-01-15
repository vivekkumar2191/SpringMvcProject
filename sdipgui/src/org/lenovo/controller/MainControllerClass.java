package org.lenovo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.lenovo.dao.NotifDao;
import org.lenovo.dao.NtfDao;
import org.lenovo.dao.PeerDao;
import org.lenovo.dao.PlanDao;
import org.lenovo.dao.SampleDao;
import org.lenovo.dao.SearchDao;
import org.lenovo.dao.TextDao;
import org.lenovo.model.Notif;
import org.lenovo.model.Ntf;
import org.lenovo.model.Peer;
import org.lenovo.model.Plan;
import org.lenovo.model.Sample;
import org.lenovo.model.Search;
import org.lenovo.model.Text_Helper;
import org.lenovo.model.UserMgt;
import org.lenovo.model.Bac;
import org.lenovo.model.Bsfusage;
import org.lenovo.model.ivrRawTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.lenovo.dao.BacDao;
import org.lenovo.dao.Bsfusagedao;
import org.lenovo.dao.EventsDao;
import org.lenovo.dao.NafDao;
import org.lenovo.model.ChangePassword;
import org.lenovo.model.Events;
import org.lenovo.model.NTFList;
import org.lenovo.model.Naf;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller

public class MainControllerClass {

    @Autowired
    TextDao dao;
    @Autowired
    SampleDao sampleDao;
  @Autowired 
  PeerDao peerDao;
    @Autowired
    PlanDao planDao;
    @Autowired
    SearchDao searchDao;
    @Autowired
    NotifDao notifDao;
    @Autowired
    EventsDao eventsDao;
    @Autowired
    Bsfusagedao bsfusagedao;
    @Autowired
    NafDao nafDao;
    @Autowired
    BacDao bacDao;
    // @Autowired
 //   IvrDao ivrDao;
//    @Autowired
//    NtfDao ntfDao;
    /*..............welcome link.............*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginPage() {
       return "welcome";
    }
    
    
    @RequestMapping(value = "/route", method = RequestMethod.GET)
    public String getroute() {

        return "route";
    }

//    @RequestMapping(value = "/updatePass", method = RequestMethod.GET)
//    public String updatePassword(@ModelAttribute("ChangePassword") ChangePassword cpass,ModelMap model) {
//    	model.addAttribute("password", cpass.getPassword());
//    	System.out.println(cpass.getPassword());
//        return "updatePass";
//    }

  
     
    /*.........notification links............*/

    
    
    @RequestMapping(value = "/notify")
    public ModelAndView getNotification(@ModelAttribute("Notif") Notif notif) {
        List<Notif> list = new ArrayList<>();
        list = notifDao.getNotifRecord();
        return new ModelAndView("notify", "list", list);/* notif is important to get value in jsp*/
    }


    
    @RequestMapping(value = "/editnotif/{notitemplateid}")
    public ModelAndView editnotif(@ModelAttribute("Notif") Notif notif, @PathVariable int notitemplateid) {
        List<Notif> list = notifDao.getNotificationid(notitemplateid);
                ModelAndView mav = new ModelAndView("editnotif");//goes to modify link
        mav.addObject("list", list);
        mav.addObject("Notif", notif);

        return mav;
    }
 
    
    
    
    
      @RequestMapping(value = "/editsavenotif", method = RequestMethod.POST)
    public ModelAndView editnotif(@ModelAttribute("Notif") Notif notif) {

        notifDao.updateNotif(notif);
        return new ModelAndView("redirect:/notify");
    }
    
    /*............searching............*/
    /*@RequestMapping(value = "/samplefilter", method = RequestMethod.GET)
    public ModelAndView samplefilter(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        List<Sample> list = sampleDao.getSamplebyId(id);

        return new ModelAndView("samplefilter", "list", list);

    }
*/    
    
    
    @RequestMapping(value = "/getplanrecord", method = RequestMethod.GET)
    public ModelAndView getplanrecord(HttpServletRequest request, @ModelAttribute("Plan") Plan plan) 
    {
     String name=request.getParameter("name");
        List<Plan> list = planDao.getplanbyName(name);
       
        return new ModelAndView("findplanrecord", "list", list);

    }

    
    
    
    @RequestMapping(value = "/textrecord", method = RequestMethod.GET)
    public ModelAndView gettextrecord(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        List<Text_Helper> list = dao.getTextByid(id);
      
        return new ModelAndView("textrecord", "list", list);

    }

    @RequestMapping(value = "/searchnotif", method = RequestMethod.GET)
    public ModelAndView getnotifrecord(HttpServletRequest request) {
        int notitemplateid = Integer.parseInt(request.getParameter("id"));
        List<Notif> list = notifDao.getNotificationid(notitemplateid);
        System.out.println(list);
        return new ModelAndView("searchnotifrecord", "list", list);

    }

    /*..............sample links...................*/
//    @RequestMapping(value = "/lenovo", method = RequestMethod.GET)
//    public String newSample() {
//        return "editsample";
//    }

	@RequestMapping("/addsample")  
    public ModelAndView showform(){  
        return new ModelAndView("addsample","command",new Sample());  
    }  

	
	@RequestMapping(value="/savesample",method = RequestMethod.POST)  
    public ModelAndView savesample(@ModelAttribute("Sample") Sample s)
	{ 
//		System.out.println("sample =======>"+s);
	sampleDao.createSample(s);
	
        return new ModelAndView("redirect:/sample");
        //will redirect to viewemp request mapping  
    }  

    @RequestMapping(value = {"/sample"}, method = RequestMethod.GET)
    public ModelAndView viewsample(@RequestParam(value = "page", required = false) Long page, Sample sample) {
        System.out.println("get values");
        List<Sample> list = sampleDao.getSample();

        return new ModelAndView("sample", "list", list);
    }

    @RequestMapping(value = "/editsample/{realm:.+}",method = RequestMethod.GET)
    public ModelAndView editsample(@ModelAttribute("Sample") Sample s, @PathVariable String realm) {
    	System.out.println("edit values");
        List<Sample> list = sampleDao.getSamplebyId(realm);
        ModelAndView mav = new ModelAndView("editsample");
        mav.addObject("list", list);
        mav.addObject("Sample", s);
        return mav;
    }
		   @RequestMapping(value="/editsavesample",method = RequestMethod.POST)  
		   public ModelAndView editSaveSample(@ModelAttribute("Sample")Sample sample,@RequestParam("Realm") String id) {
//		        String id = request.getParameter("id");
			   sampleDao.updateSample(sample,id);  
		       return new ModelAndView("redirect:/sample");  
		   }  

    
    @RequestMapping(value = "/deletesample/{id:.+}", method = RequestMethod.GET)
    public ModelAndView deletesample(@PathVariable String id) {
        sampleDao.deleteSample(id);
        return new ModelAndView("redirect:/sample");
    }

    /*............sms...............*/
    @RequestMapping(value = "/sms", method = RequestMethod.GET)
    public String getSMS() {

        return "sms";
    }

    /*..............text links.................*/
    @RequestMapping(value = "/text", method = RequestMethod.GET)
    public ModelAndView viewtext() {
        List<Text_Helper> list = dao.getText();
        return new ModelAndView("text", "list", list);
    }

    @RequestMapping("/addtext")
    public ModelAndView showaddtext() {
        return new ModelAndView("addtext", "command", new Text_Helper());
    }

    @RequestMapping(value = "/savetext", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("Text_Helper") Text_Helper text) {
        dao.saveText(text);
        return new ModelAndView("redirect:/text");
    }

    @RequestMapping(value = "/edittext/{fieldid}")
    public ModelAndView modifytext(@ModelAttribute("Text_Helper") Text_Helper text, @PathVariable int fieldid) {
        List<Text_Helper> list = dao.getTextByid(fieldid);
        ModelAndView mav = new ModelAndView("edittext");
        mav.addObject("list", list);
        mav.addObject("Text_Helper", text);

        return mav;
    }

    /* It updates model object. */
    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("Text_Helper") Text_Helper text) {

        dao.updateText(text);
        return new ModelAndView("redirect:/text");
    }

    @RequestMapping(value = "/deletetext/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id) {
        dao.deleteText(id);
        return new ModelAndView("redirect:/text");
    }



    /*..............plan.........................*/
    @RequestMapping(value = "/plan")
   public ModelAndView Plan() {
   
       List<Plan> list = new ArrayList<>();
       list = planDao.getRecord();
        return new ModelAndView("plan", "list", list);

    }


    @RequestMapping(value = "/editplan/{name}")
    public ModelAndView editplan(@ModelAttribute("Plan") Plan plan, @PathVariable String name) {
        List<Plan> list = planDao.getplanbyName(name);
        ModelAndView mav = new ModelAndView("editplan");
        mav.addObject("list", list);
        mav.addObject("Plan", plan);
       
        return mav;
    }

    @RequestMapping(value = "/editsaveplan", method = RequestMethod.POST)
    public ModelAndView editplan
    
    (@ModelAttribute("Plan") Plan plan) {

        planDao.updatePlan(plan);

        return new ModelAndView("redirect:/plan");
    }

    /*....................ivr........................*/

/*    @RequestMapping(value = "/ivr/{notitemplateid}/{fieldtypeid}")
    public ModelAndView ivrPage(HttpServletRequest request,@ModelAttribute("Notif") Notif notif, @ModelAttribute("Sample") Sample sample,@ModelAttribute("Ntf") Ntf ntf,@PathVariable int notitemplateid ,@PathVariable int fieldtypeid) {
        
    	
        List<Ntf> ntfList =ntfDao.getNtfRecord(notitemplateid,fieldtypeid);
    	List<Notif> templateid=new ArrayList<>();
    	templateid=notifDao.getNotificationid(notitemplateid);
    	List<Ntf> listLang =new ArrayList<Ntf>();
    	 listLang=ntfDao.getLang();
    	   List<Sample> list1 = new ArrayList<Sample>();
           list1 = sampleDao.notifyLeftTable();

           List<Sample> list2=new ArrayList<Sample>();
                 list2=sampleDao.notifyRightTable();
                 
                 
        List<Notif> list = notifDao.getNotificationid(notitemplateid);
                ModelAndView mav = new ModelAndView("ivr");//goes to modify link
                mav.addObject("templateid",templateid);
                mav.addObject("Notif",notif);
//        mav.addObject("list", list);
//        mav.addObject("Notif", notif);
        mav.addObject("list1", list1);
        mav.addObject("Sample", sample);
        mav.addObject("list2", list2);
        mav.addObject("Sample", sample);
        mav.addObject("listLang", listLang);
        mav.addObject("Ntf", ntf);
        mav.addObject("ntfList", ntfList);
        mav.addObject("Ntf", ntf);
       
  
        return mav;
    }
    
*/    
    

 /*   @RequestMapping(value = "/sms/{notitemplateid}/{typeid}")
    public ModelAndView smsPage(HttpServletRequest request,@ModelAttribute("Notif") Notif notif, @ModelAttribute("Sample") Sample sample,@ModelAttribute("Ntf") Ntf ntf,@PathVariable int notitemplateid ,@PathVariable int typeid) {
        
    	
        List<Ntf> smsList =ntfDao.getSmsRecord(notitemplateid, typeid);
        	System.out.println("SmsList====>"+smsList);
    	List<Notif> templateid=new ArrayList<>();
    	templateid=notifDao.getNotificationid(notitemplateid);
    	List<Ntf> listLang =new ArrayList<Ntf>();
    	 listLang=ntfDao.getLang();
    	   List<Sample> list1 = new ArrayList<Sample>();
           list1 = sampleDao.notifyLeftTable();

           List<Sample> list2=new ArrayList<Sample>();
                 list2=sampleDao.notifyRightTable();
                 
                 
        List<Notif> list = notifDao.getNotificationid(notitemplateid);
                ModelAndView mav = new ModelAndView("sms");//goes to modify link
                mav.addObject("templateid",templateid);
                mav.addObject("Notif",notif);
//        mav.addObject("list", list);
//        mav.addObject("Notif", notif);
        mav.addObject("list1", list1);
        mav.addObject("Sample", sample);
        mav.addObject("list2", list2);
        mav.addObject("Sample", sample);
        mav.addObject("listLang", listLang);
        mav.addObject("Ntf", ntf);
        mav.addObject("smsList", smsList);
        mav.addObject("Ntf", ntf);
       
  
        return mav;
    }
 
*/
    
//
//    
//    @RequestMapping(value = "/ivr/{notitemplateid}/{fieldtypeid}")
//    public ModelAndView smsPage(HttpServletRequest request,@ModelAttribute("Notif") Notif notif, @ModelAttribute("Sample") Sample sample,@ModelAttribute("Ntf") Ntf ntf,@PathVariable int notitemplateid,@PathVariable int fieldtypeid) {
//        
//    	
//        List<Ntf> ntfList =ntfDao.getNtfRecord(notitemplateid,fieldtypeid);
//       
//
//    	List<Notif> templateid=new ArrayList<>();
//    	templateid=notifDao.getNotificationid(notitemplateid);
//    	List<Ntf> listLang =new ArrayList<Ntf>();
//    	 listLang=ntfDao.getLang();
//    	   List<Sample> list1 = new ArrayList<Sample>();
//           list1 = sampleDao.notifytab3();
//
//           List<Sample> list2=new ArrayList<Sample>();
//                 list2=sampleDao.eventtab2();
//                 
//        List<Notif> list = notifDao.getNotificationid(notitemplateid);
//                ModelAndView mav = new ModelAndView("sms");//goes to modify link
//                mav.addObject("templateid",templateid);
//                mav.addObject("Notif",notif);
////        mav.addObject("list", list);
////        mav.addObject("Notif", notif);
//        mav.addObject("list1", list1);
//        mav.addObject("Sample", sample);
//        mav.addObject("list2", list2);
//        mav.addObject("Sample", sample);
//        mav.addObject("listLang", listLang);
//        mav.addObject("Ntf", ntf);
//        mav.addObject("ntfList", ntfList);
//        mav.addObject("Ntf", ntf);
//        
//       
//  
//        return mav;
//    }
// 
    @RequestMapping(value = "/deletefieldid/{id}", method = RequestMethod.GET)
    public ModelAndView deleteIvrRecord(@PathVariable int id) {
        notifDao.deleteIvrRecord(id);
        return new ModelAndView("redirect:../notify");
    }


 /*@RequestMapping(value = "/tabres/{fieldid}")
 @ResponseBody
    public ModelAndView tabres(@ModelAttribute("Sample") Sample s, @PathVariable int fieldid) {
        List<Sample> list4 = sampleDao.getSamplebyId(fieldid);
        ModelAndView mav = new ModelAndView("nextivr");
        mav.addObject("list4", list4);
        mav.addObject("Sample", s);
        return mav;
    }
   
 @RequestMapping(value = "/mycontent/{fieldid}")
    public ModelAndView mycontent(@ModelAttribute("Sample") Sample s, @PathVariable int fieldid) {
        sampleDao.getSamplebyId(fieldid);
        ModelAndView mav = new ModelAndView("ivr");
        mav.addObject("Sample", s);
        return mav;
    }

*/
 
//
// @RequestMapping(value = "/sms",method=RequestMethod.POST)
// public JSONObject ntf(@RequestParam Ntf ntf,HttpServletRequest request) throws JSONException
// {	
//
//System.out.println(ntf.getLang_id().toString());
//
//	 org.json.JSONObject response = new org.json.JSONObject();
//	 response.put("success", true);
//	 response.toString(); 
//	 return response;
//	   }

	 
	 
	 
////	 Gson gson =new Gson();
////	List<Ntf> ntfList = Arrays.asList(gson.fromJson(data, Ntf[].class));
////
////	for (Ntf ntf : ntfList) {
////	
////	}
//	 ObjectMapper mapper =new ObjectMapper();
//	 try {
//	NTFList list=mapper.reader(obj);
//	List<Ntf> dataList=list.getNtf();
//	for (Ntf dataItem : dataList) {
//		System.out.println(dataItem.getFieldtypeid());
//	}
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		// TODO: handle exceptions
//	}
////	 
//	 System.out.println(data);
//	 try {
//		ntfDao.dataNtf(ntfList);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//
//	 org.json.JSONObject response = new org.json.JSONObject();
//	 response.put("success", true);
//	 response.toString(); 
//	 return response;

  
 
/*..............Events..........*/
 @RequestMapping(value = "/events", method = RequestMethod.GET)
public String getevents(){
	 return "events";

}
 
 
    /*..................logout.................*/
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String getLogin() {

        return "logout";
    }

    
    @RequestMapping(value = {"/peer"}, method = RequestMethod.GET)
    public ModelAndView viewPeer(@RequestParam(value = "page", required = false) Long page, Peer peer) {

        List<Peer> list = peerDao.getPeer();
        System.out.println("............"+peer.getHost_name());

        return new ModelAndView("peer", "list", list);
    }


    @RequestMapping("/addpeer")
    public ModelAndView showpeer() {
       
      return new ModelAndView("addpeer", "command", new Peer());

    }


    @RequestMapping(value = "/savepeer", method = RequestMethod.POST)
    public ModelAndView savepeer(@ModelAttribute("Peer") Peer s) {

//        sampleDao.createSample(s);
    	peerDao.createPeer(s);

        return new ModelAndView("redirect:/peer");

    }

    @RequestMapping(value = "/editsavepeer", method = RequestMethod.POST)
    public ModelAndView editPeer(@ModelAttribute("Peer") Peer s, @RequestParam("Host_name") String id) {
    //public ModelAndView editSample(@ModelAttribute("Sample")Sample sample,@RequestParam("Realm") String id) {	
//    	
//     System.out.println("final value of host_name is:"+s);

    peerDao.updatePeer(s, id);

    
//        sampleDao.updateSample(s);
        return new ModelAndView("redirect:/peer");
    }

    /*............editpeer/{host_name}*/
    @RequestMapping(value = "/editpeer/{host_name:.+}")
    public ModelAndView editPeerPage(@ModelAttribute("Peer") Peer s, @PathVariable String host_name) {


        List<Peer> list = peerDao.getPeerbyName(host_name);
        ModelAndView mav = new ModelAndView("/editpeer");
        mav.addObject("list", list);
        mav.addObject("Peer", s);
        return mav;
    }
    @RequestMapping(value = "/deletepeer/{host_name:.+}", method = RequestMethod.GET)
    public ModelAndView deletepeer(@PathVariable String host_name) {
    peerDao.deletePeer(host_name);
        return new ModelAndView("redirect:/peer");
    }

    
    
    
    
    
    
    
    
    
    
    
    @RequestMapping(value = {"/bsfusage"}, method = RequestMethod.GET)
    public ModelAndView viewbsfusage(@RequestParam(value = "page", required = false) Long page, Bsfusage usage) {
System.out.println("get values");


   List<Bsfusage> list = bsfusagedao.getbsfusage();

        return new ModelAndView("bsfusage", "list", list);
    }

    @RequestMapping(value = "/editusagewarning/{high_usage_warning}",method = RequestMethod.GET)
    public ModelAndView editusagewarning(@ModelAttribute("Bsfusage") Bsfusage s, @PathVariable int high_usage_warning) {
    	System.out.println("edit values");
        List<Bsfusage> list = bsfusagedao.getBSFusagebyId(high_usage_warning);
        ModelAndView mav = new ModelAndView("editusagewarning");
        mav.addObject("list", list);
        mav.addObject("Bsfusage", s);
        return mav;
    }
		   @RequestMapping(value="/editsaveusagewarning",method = RequestMethod.POST)  
		   public ModelAndView editSampleusagewarning(@ModelAttribute("usagewarning")Bsfusage b,@RequestParam("High_usage_warning") int id) {
//		        String id = request.getParameter("id");
			   bsfusagedao.updatebsfusage(b,id);  
		       return new ModelAndView("redirect:/bsfusage");  
		   }  

		   
		   


		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
      @RequestMapping(value = "/editlevel/{level}",method = RequestMethod.GET)
		    public ModelAndView editlevel(@ModelAttribute("Bsfusage") Bsfusage s, @PathVariable int level) {
		    	System.out.println("edit values");
		        List<Bsfusage> list = bsfusagedao.getBSFusagebyId2(level);
		        ModelAndView mav = new ModelAndView("editlevel");
		        mav.addObject("list", list);
		        mav.addObject("Bsfusage", s);
		        return mav;
		    }
				   @RequestMapping(value="/editsavelevel",method = RequestMethod.POST)  
				   public ModelAndView editusagelevel(@ModelAttribute("level")Bsfusage b,@RequestParam("Level") int id) {
//				        String id = request.getParameter("id");
					   bsfusagedao.updatebsfusage2(b,id);  
				       return new ModelAndView("redirect:/bsfusage");  
				   }  

         /*............naf.............*/
				   @RequestMapping(value = {"/naf"}, method = RequestMethod.GET)
				    public ModelAndView viewnafprovisioning(@RequestParam(value = "page", required = false) Long page, Naf naf){
				    	System.out.println("hello");
				    	List<Naf> list=nafDao.getNaf();
				    	
				       return new ModelAndView("naf","list", list);
				    }
				    @RequestMapping("/addnaf")
				    public ModelAndView shownaf() {
				       
				      return new ModelAndView("addnaf", "command", new Naf());

				    }
				    @RequestMapping(value = "/savenaf", method = RequestMethod.POST)
				    public ModelAndView savenaf(@ModelAttribute("Naf") Naf n) {
				          System.out.println("naf data save");
//				        sampleDao.createSample(s);
				    	nafDao.createNaf(n);

				        return new ModelAndView("redirect:/naf");

				    }
				    
				    @RequestMapping(value = "/editnaf/{domain_name}")
				    public ModelAndView editNafPage(@ModelAttribute("Naf") Naf n, @PathVariable String domain_name) {
				    

				        List<Naf> list = nafDao.getNafbyName(domain_name);
				        System.out.println(nafDao.getNafbyName(domain_name));
				        ModelAndView mav = new ModelAndView("editnaf");
				      
				        mav.addObject("list", list);
				        mav.addObject("Naf", n);
				        return mav;
				    }
				    @RequestMapping(value="/editsavenaf",method = RequestMethod.POST)  
				   	public ModelAndView editsavenaf(HttpServletRequest request,@ModelAttribute("Naf") Naf n, @RequestParam("Domain_name") String id) {
				   		      System.out.println("edit save naf controller");  
				        //name = request.getParameter("name");
				               System.out.println(id);
				   			   nafDao.updateNaf(n, id);
				   			   
				   		       return new ModelAndView("redirect:/naf");  
				   } 
				    
				    
	 @RequestMapping(value = {"/bac"}, method = RequestMethod.GET)
				    public ModelAndView viewBac(@RequestParam(value = "page", required = false) Long page,@ModelAttribute("bac") Bac bac) {

				        List<Bac> list =new ArrayList();
				        list=bacDao.getBac();
				        for(int i=0;i<list.size();i++)
				        {
				        	
				        	Bac b=list.get(i);
				        	//System.out.println(b.getBSF_server_name());
				        	//System.out.println(b.getCDR_Transfer_Server());
				        	//System.out.println(b.getCDR_Transfer_Server_details());
				        }
                       System.out.println("..............."+list.isEmpty());
				        return new ModelAndView("bac","list", list);
				    }

				    /*@RequestMapping(value = "/editbac/{bsf_server_name:.+}",method = RequestMethod.GET)
				    public ModelAndView editBac(@ModelAttribute("Bac") Bac bac, @PathVariable String bsf_server_name) {
				    	System.out.println("edit values");
				        List<Bac> list = bacDao.getBacByServerName(bsf_server_name);
				        ModelAndView mav = new ModelAndView("editbac");
				        mav.addObject("list", list);
				        mav.addObject("Bac", bac);
				        System.out.println(mav);
				        
				        return mav;
				    } */
				    
				    @RequestMapping(value="/bac",method = RequestMethod.POST)  
				   	public ModelAndView editsavebac(HttpServletRequest request,@ModelAttribute("Bac") Bac b, @RequestParam("Bsf_server_name") String id) {
				   		      System.out.println("edit save bac controller");  
				        //name = request.getParameter("name");
				               System.out.println(id);
				   			   bacDao.updateBac(b, id);
				   			   System.out.println("hii");
				   			   
				   		       return new ModelAndView("redirect:/bac");  
				   } 
				    
}
