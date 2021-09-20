package com.g3.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.g3.domain.Ad_ProductVO;
import com.g3.service.Ad_ProductService;
import com.g3.utils.UploadFileUtils;
import com.google.gson.JsonObject;


//@RequestMapping("/AdminProduct/*") : /AdminProduct/~ 모든 주소에 접근을 제어한다. 컨트롤러에도 적용가능한 애너테이션

@Controller
@RequestMapping("/AdminProduct/*")
public class AdProductController {
   
   private static final Logger logger =
         LoggerFactory.getLogger(AdProductController.class);
   
   // 서비스 객체를 주입
   // 컨트롤러는 서버를 통해서만 실행가능
   @Inject
   private Ad_ProductService service;
   
   //servlet.xml에 추가한 업로드패스 불러오기
   @Resource(name="uploadPath")
   private String uploadPath;
   
   //http://localhost:8088/web/AdminProduct/addProduct
   
   @RequestMapping(value="/addProduct", method = RequestMethod.GET)
   public void AddProductGETs() throws Exception {
	   System.out.println("AddProductGETs() 호출");

	   
   }
   
	// 상품 등록
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String postGoodsRegister(Ad_ProductVO advo, MultipartFile file) throws Exception {
		
		System.out.println("AddProductPOSTs() 호출");
		   
		   
	 
	 String imgUploadPath = uploadPath + File.separator + "imgUpload"; // 이미지를 업로드할 폴더를 설정 = /uploadPath/imgUpload
	 String ymdPath = UploadFileUtils.calcPath(imgUploadPath); // 위의 폴더를 기준으로 연월일 폴더를 생성
	 String fileName = null; // 기본 경로와 별개로 작성되는 경로 + 파일이름
	   
	 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
	  // 파일 인풋박스에 첨부된 파일이 있다면(=첨부된 파일이 이름이 있다면)
	  
	  fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);

	  // gdsImg에 원본 파일 경로 + 파일명 저장
	  advo.setP_image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
	  // gdsThumbImg에 썸네일 파일 경로 + 썸네일 파일명 저장
	  advo.setP_thumbimg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
	  
	 } else { // 첨부된 파일이 없으면
	  fileName = File.separator + "images" + File.separator + "none.png";
	  // 미리 준비된 none.png파일을 대신 출력함
	  
	  advo.setP_image(fileName);
	  advo.setP_thumbimg(fileName);
	 }
	      
	 service.AddProduct(advo);
	 System.out.println("상품추가성공!!");
	 return "redirect:/AdminProduct/ProductSearchList?pgnum=1";	
	 
	}
	
	// ck 에디터에서 파일 업로드
	@RequestMapping(value = "/ckUpload", method = RequestMethod.POST)
	public void postCKEditorImgUpload(HttpServletRequest req,
	         						  HttpServletResponse res,
	         						  @RequestParam MultipartFile upload) throws Exception {
	 logger.info("post CKEditor img upload");
	 
	 JsonObject json = new JsonObject();
	 
	 // 랜덤 문자 생성
	 UUID uid = UUID.randomUUID();
	 
	 OutputStream out = null;
	 PrintWriter printWriter = null;
	   
	 // 인코딩
	 res.setCharacterEncoding("utf-8");
	 res.setContentType("text/html;charset=utf-8");
	 
	 try {
	  
	  String fileName = upload.getOriginalFilename(); // 파일 이름 가져오기
	  byte[] bytes = upload.getBytes();
	  
	  // 업로드 경로
	  String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;
	  System.out.println(ckUploadPath);
	  out = new FileOutputStream(new File(ckUploadPath));
	  out.write(bytes);
	  out.flush(); // out에 저장된 데이터를 전송하고 초기화
	  
	  String callback = req.getParameter("CKEditorFuncNum");
	  printWriter = res.getWriter();
	  String fileUrl = "../ckUpload/" + uid + "_" + fileName; // 작성화면
	  
//	  json.addProperty("uploaded", 1);
//	  json.addProperty("fileName", fileName);
//	  json.addProperty("url", fileUrl);
//	  json.addProperty("ckUploadPath", ckUploadPath);
//	  printWriter.println(json);
	  
	  // 업로드시 메시지 출력
	  printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
	  

	  
	 } catch (IOException e) { e.printStackTrace();
	 } finally {
	  try {
	   if(out != null) { out.close(); }
	   if(printWriter != null) { printWriter.close(); }
	  } catch(IOException e) { e.printStackTrace(); }
	 }
	 
	 return; 
	}
	

   

   

//	// 게시물 목록 + 페이징 추가+ 검색
	@RequestMapping(value = "/ProductSearchList", method = RequestMethod.GET)
	public void getListPageSearch(Model model, @RequestParam("pgnum") int pgnum,
			@RequestParam(value = "searchType",required = false, defaultValue = "p_name") String searchType,
			   @RequestParam(value = "keyword",required = false, defaultValue = "") String keyword) throws Exception {
	 
	 // 게시물 총 갯수
	 int count=service.searchCount(searchType, keyword);
	  
	 // 한 페이지에 출력할 게시물 갯수
	 int postNum = 10;
	  
	 // 하단 페이징 번호 ([ 게시물 총 갯수 ÷ 한 페이지에 출력할 갯수 ]의 올림)
	 int pageNum = (int)Math.ceil((double)count/postNum);
	  
	 // 출력할 게시물
	 int displayPost = (pgnum - 1) * postNum;
	//한번에 표시할 페이징 번호의 갯수
	int pageNum_cnt = 10;
	
	//표시되는 페이지 번호 중 마지막 번호
	int endPageNum = (int)(Math.ceil((double)pgnum / (double)pageNum_cnt) * pageNum_cnt);
	
	//표시되는 페이지 번호 중 첫번째 번호
	int startPageNum = endPageNum - (pageNum_cnt - 1);
	//마지막 번호 재계산
	int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
	
	if(endPageNum > endPageNum_tmp) {
	endPageNum = endPageNum_tmp;
	}
	boolean prev = startPageNum == 1 ? false : true;
	boolean next = endPageNum * pageNum_cnt >= count ? false : true;
	
//	 List list = null; 
//	 list = service.listPage(displayPost, postNum);
	 
	 List<Ad_ProductVO> list = null; 
	 list = service.listPageSearch(displayPost,postNum, searchType, keyword);
	 
	 
	 model.addAttribute("list", list);   
	 model.addAttribute("pageNum", pageNum);
	 
	//시작 및 끝 번호
	model.addAttribute("startPageNum", startPageNum);
	model.addAttribute("endPageNum", endPageNum);
	
	//이전 및 다음 
	model.addAttribute("prev", prev);
	model.addAttribute("next", next);
	//현재 페이지
	model.addAttribute("select", pgnum);
	//검색시 입력받은 검색조건과 검색어를 저장하여 다른페이지를 클릭해도 검색조건과 검색어가 그대로 뷰에 보이게 하기위함
	model.addAttribute("searchType", searchType);
	model.addAttribute("keyword", keyword);
	
	 String searchTypeKeyword;
	
	 if(searchType.equals("") || keyword.equals("")) {
		  searchTypeKeyword = ""; 
		 } else {
		   searchTypeKeyword = "&searchType=" + searchType + "&keyword=" + keyword; 
		 }  
	 
	 model.addAttribute("searchTypeKeyword",searchTypeKeyword);
		}
	
	
   @RequestMapping(value="/ProductUpdate",method = RequestMethod.GET)
   public void UpdateProductGET(@RequestParam("p_num") int p_num,Model model,HttpSession session ,@RequestParam("pgnum") int pgnum) throws Exception{
	   logger.info("UpdateProductGET()호출 @@@@@ ");
	   
	   session.setAttribute("p_num", session);
	   
	   Ad_ProductVO avo=service.getProduct(p_num);
	   
	   logger.info("정보 "+avo);
	   model.addAttribute("avo",avo);
	   //현재 수정페이지에 들어오기전 페이지수
	   model.addAttribute("pgnum", pgnum);
   }
   
   @RequestMapping(value="/ProductUpdate",method = RequestMethod.POST)
   public String UpdateProductPOST(Ad_ProductVO advo) throws Exception{
   
	   service.ModifyProduct(advo);
	   
	   
        return"redirect:./ProductList";
}
   @RequestMapping(value="/ProductDetail",method=RequestMethod.GET)
   public void getProductGET(@RequestParam("p_num") int p_num, Model model, @RequestParam("pgnum") int pgnum)throws Exception{
	   
	   
	   Ad_ProductVO avo= service.getProduct(p_num);
	   model.addAttribute("avo",avo);
	   //상세페이지에 들어오기전 목록페이지수
	   model.addAttribute("pgnum", pgnum);
   } 
   @RequestMapping(value="/delete", method = RequestMethod.GET)
   public String deleteProduct(int p_num) throws Exception{
      logger.info("deleteProduct() 호출@@@@");
      System.out.println(p_num);
      service.CutProduct(p_num);
      return "redirect:/AdminProduct/ProductSearchList?pgnum=1";
   }
   
   
   
}