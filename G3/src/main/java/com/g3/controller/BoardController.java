package com.g3.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.g3.domain.BoardVO;
import com.g3.service.BoardService;
import com.g3.utils.UploadFileUtils;


@Controller
@RequestMapping("/board/*")
public class BoardController {
   
   private static final Logger logger =
         LoggerFactory.getLogger(BoardController.class);
   
   
   @Inject
   private BoardService service;
   
   @Resource(name="uploadPath")
   private String uploadPath;
 
   // http://localhost:8088/board/boardList
   //보드 리스트 페이지 이동
   @RequestMapping(value ="/boardList", method =  RequestMethod.GET)
   public String board_listGET(BoardVO bovo, Model model, HttpSession session) {
	   
	   logger.info("board_listGET() 호출!!");
	   model.addAttribute("boardList", service.getBoardList());
	  
	   logger.info(session.getAttribute("id")+"");
//	   String id = (String) session.getAttribute("id");
//	   if(id==null) {
//		   return "redirect:../member/main";
//	   }
//	   session.setAttribute("id", id);
	   logger.info("@@@"+service.getBoardList());
	   return "board/boardList";
   }
  
   // 글쓰기 페이지 이동
   @RequestMapping(value ="/boardWrite", method =  RequestMethod.GET)
   public String boardWriteGET(HttpSession session) {
	   logger.info("boardWriteGET() 호출!!!");
//	   String id = (String)session.getAttribute("id");
//	   if(id==null) {
//		   return "redirect:../member/main";
//	   }
//	   session.setAttribute("id", id);
	   return "board/boardWrite";
   }
   
   //글쓰기 디비 저장
   @RequestMapping(value ="/boardWrite", method =  RequestMethod.POST)
   public String boardWritePOST(HttpSession session,BoardVO vo,Model model, MultipartFile file) throws IOException, Exception {
	   logger.info("boardWrite() 호출");
//	   String id = (String)session.getAttribute("id");
//	   if(id==null) {
//		   return "redirect:../member/main";
//	   }
//	   session.setAttribute("id", id);
	  
	   String imgUploadPath = uploadPath + File.separator + "imgUpload";
	   String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
	   String fileName = null;

	   
	   if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
	    fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
	    vo.setBo_p_image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		vo.setBo_p_thumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
	   
	   } else {
	    //파일 업로드 x  
		logger.info("첨부파일없음");
		
	   }

//	   bovo.setBo_p_image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
//	   bovo.setBo_thumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
	  
	   service.insertBoard(vo);
	   model.addAttribute("boardList", service.getBoardList());
	   
	   
	   return "redirect:./boardList";
   }
   
// ck파일 업로드
	@RequestMapping(value = "/ckUpload", method = RequestMethod.POST)
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, @RequestParam MultipartFile upload) throws Exception {
	 logger.info("post CKEditor img upload");
	 

	 UUID uid = UUID.randomUUID();
	 
	 OutputStream out = null;
	 PrintWriter printWriter = null;
	   
	 res.setCharacterEncoding("utf-8");
	 res.setContentType("text/html;charset=utf-8");
	 try {
	  
	  String fileName = upload.getOriginalFilename();
	  byte[] bytes = upload.getBytes();
	  
	  String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;
	  
	  out = new FileOutputStream(new File(ckUploadPath));
	  out.write(bytes);
	  out.flush();
	  
	  String callback = req.getParameter("CKEditorFuncNum");
	  printWriter = res.getWriter();
	  String fileUrl = "../resources/ckUpload/" + uid + "_" + fileName;
	  
	  printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");

	
		 
		  printWriter.flush();
		  
		 } catch (IOException e) { e.printStackTrace();
		 } finally {
		  try {
		   if(out != null) { out.close(); }
		   if(printWriter != null) { printWriter.close(); }
		  } catch(IOException e) { e.printStackTrace(); }
		 }
		 
		 return; 
		}
   
	//ck 파일 수정
	@RequestMapping(value = "/ckUploadModify", method = RequestMethod.POST)
	public void postCKEditorImgUploadModify(HttpServletRequest req, HttpServletResponse res, @RequestParam MultipartFile upload) throws Exception {
		logger.info("post CKEditor img upload");
		
		UUID uid = UUID.randomUUID();
		
		OutputStream out = null;
		PrintWriter printWriter = null;
		
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		try {
			
			String fileName = upload.getOriginalFilename();
			byte[] bytes = upload.getBytes();
			
			String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;
			
			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			out.flush();
			
			String callback = req.getParameter("CKEditorFuncNum");
			printWriter = res.getWriter();
			String fileUrl = "../resources/ckUpload/" + uid + "_" + fileName;
			
			printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
			
			
			
			printWriter.flush();
			
		} catch (IOException e) { e.printStackTrace();
		} finally {
			try {
				if(out != null) { out.close(); }
				if(printWriter != null) { printWriter.close(); }
			} catch(IOException e) { e.printStackTrace(); }
		}
		
		return; 
	}
	
	
   // 답글 페이지 이동
   @RequestMapping(value ="/reBoardWrite", method =  RequestMethod.GET)
   public String reBoardWriteGET(HttpSession session, HttpServletRequest request) {
	   logger.info("reBoardWriteGET() !!!");
//	   String id = (String)session.getAttribute("id");
//	   if(id==null) {
//		   return "redirect:../member/main";
//	   }
//	   session.setAttribute("id", id);
	   
	   int bo_num = Integer.parseInt(request.getParameter("bo_num"));
	   
	   request.setAttribute("bo_num", bo_num);
	   logger.info(bo_num+"");
	   
	   return "board/reBoardWrite";
   }
   
   // 답글 디비 저장
   @RequestMapping(value ="/reBoardWrite", method =  RequestMethod.POST)
   public String reBoardWritePOST(HttpSession session, HttpServletRequest request, BoardVO vo) {
	   logger.info("reBoardWritePOST() !!!");
//	   String id = (String)session.getAttribute("id");
//	   if(id==null) {
//		   return "redirect:../member/main";
//	   }
//	   session.setAttribute("id", id);
	   service.reWriteBoard(vo);
	   
	   
	   
	   return "redirect:./boardList";
   }
   
   //카테고리 분류
   @RequestMapping(value="/boardCategory", method = RequestMethod.GET)
   public String boardCategoryGET(HttpServletRequest request, Model model,BoardVO vo, HttpSession session) {
	   logger.info("boardCategoryGET(HttpServletRequest request)!!!");
	   logger.info(request.getParameter("category"));
//	   String id = (String)session.getAttribute("id");
//	   if(id==null) {
//		   return "redirect:../member/main";
//	   }
//	   session.setAttribute("id", id);
	   
	   String bo_category = request.getParameter("category");
	   List<BoardVO> categoryBoardList = service.getCategoryBoardList(bo_category);
	   model.addAttribute("categoryBoardList", categoryBoardList);
	   
	   return "board/categoryBoardList";
   }
   
   //글 확인
   @RequestMapping(value="/boardContent", method = RequestMethod.GET)
   public String boardContentGET(HttpServletRequest request, Model model,BoardVO vo, HttpSession session) {
	   logger.info("boardContentGET(HttpServletRequest request) !!!");
	   
	   int bo_num = Integer.parseInt(request.getParameter("bo_num"));
//	   String id = (String)session.getAttribute("id");
//	   if(id==null) {
//		   return "redirect:../member/main";
//	   }
//	   session.setAttribute("id", id);
	   vo = service.getBoardContent(bo_num);
	   
	   model.addAttribute("vo",vo);
	   
	   return "board/boardContent";
	   
   }
   
   // 글 삭제 
  @RequestMapping(value="/deleteContent", method = RequestMethod.GET)
  public String deleteContentGET(@RequestParam("bo_num")int bo_num) throws Exception {
	  logger.info("deleteContent( )!!!");
	  logger.info(bo_num+"");
	  
	  service.deleteContent(bo_num);
	  
	  
	  return "redirect:./boardList";
  }
   
  
  //글 수정 페이지 이동
  @RequestMapping(value = "/modify" , method = RequestMethod.GET)
  public void modifyGET(int bo_num, Model model ) throws Exception{
	  logger.info("modifyGET( )!!!");
	  
	  BoardVO vo = service.getBoardContent(bo_num);
	  
	  model.addAttribute("vo", vo);
	  
  }
   
  //글수정 디비 저장
  @RequestMapping(value = "/modify" , method = RequestMethod.POST)
  public String modifyPOST(int bo_num, Model model, BoardVO vo, MultipartFile file ) throws Exception{
	  logger.info("modifyGET( ) !!!");
	  String imgUploadPath = uploadPath + File.separator + "imgUpload";
	   String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
	   String fileName = null;

	   
	   if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
	    fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
	    vo.setBo_p_image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		vo.setBo_p_thumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
	   
	   } else {
	    //fileName = uploadPath + File.separator + "images" + File.separator + "none.png"; none �옄�룞�궫�엯
		 logger.info("업로드 파일 없음!");
	   }
	  
	  
	  service.modify(vo);
	  
	  return "redirect:./boardList";
	  
  }
  
	   
		   
   
   
   
}