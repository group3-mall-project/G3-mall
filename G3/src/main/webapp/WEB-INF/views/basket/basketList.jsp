<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>
<%@ include file="../include/basketNav.jsp" %>

  <!--================Cart Area =================-->
  
  <section class="cart_area">
       <div class="container">
          <div class="cart_inner">
              <div class="table-responsive">
                  <table class="table">
                      <thead>
                          <tr>
                          	  <th><input type="checkbox" id="chkAll" value="chkAll" checked/></th>
                          	  <c:set var="nbsp" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"/>
                              <th scope="col"><b>${nbsp}${nbsp}사진 ${nbsp}${nbsp}${nbsp}${nbsp} 제품 &nbsp; 옵션</b></th>
                              <th scope="col"><b>가격</b></th>
                              <th scope="col"><b>수량</b></th>
                              <th scope="col"><b>가격합계</b></th>
                              <th scope="col"><b>삭제</b></th>
                          </tr>
                      </thead>
                      <tbody>
                      <c:choose>
                      	<c:when test="${empty basketList}">
                      		<tr>
                      			<td></td>
                      			<td colspan="3" style="text-align: center;">
                      			<h2> 장바구니가 비었습니다. </h2>
                      			</td>
                      			<td></td>
                      		</tr>
                      	</c:when>
                      	<c:otherwise>
							<c:forEach var="basketVO" items="${basketList}" varStatus="b">
							<c:forEach var="productVO" items="${productList}" varStatus="p">
								<c:if test="${b.index eq p.index}">
		                          <tr>
			                          <td>
			                          	<input type="checkbox" class="chk" name="b_num" value="${basketVO.b_num}" checked>
			                          </td>
		                              <td>
		                                  <div class="media">
		                                      <div class="d-flex">
		                                          <a href="#"><!-- @@@@productDetail 뷰페이지로 보내야함@@@ --><img src="${productVO.p_thumbimg }" alt="" style="width:100px;height:100px;"></a>
		                                      </div>
		                                      <div class="media-body">
		                                          <a href="#"><!-- @@@@productDetail 뷰페이지로 보내야함@@@ --><h2>${productVO.p_name }</h2></a>
		                                          <p>${basketVO.b_p_option }</p>
		                                      </div>
		                                  </div>
		                              </td>
		                              
		                              <td>
		                                  <h5>${productVO.p_price }</h5>
		                              </td>
		                              <td>
		                                  <div class="product_count">
		                                      <form action="./amountChange" method="post">
		                                      <input type="hidden" id="b_num" name="b_num" value="${basketVO.b_num }">
		                                      <input type="hidden" id="p_amount" name="p_amount" value="${productVO.p_amount }">
		                                      <select name="b_p_amount" id="qty" onchange="this.form.submit()" size="5" multiple="multiple">
		                                      		<!-- db 현재수량 +-2개씩 보여줌 1이나 2일때는 아래쪽으로 4개나 3개,위쪽1개 보여줌-->
		                                      		<c:if test="${basketVO.b_p_amount eq 1}">
		                                      			<option value="${basketVO.b_p_amount }" selected>${basketVO.b_p_amount }</option>
		                                      			<option value="${basketVO.b_p_amount+1 }">${basketVO.b_p_amount+1 }</option>
		                                      			<option value="${basketVO.b_p_amount+2 }">${basketVO.b_p_amount+2 }</option>
     					                                <option value="${basketVO.b_p_amount+3 }">${basketVO.b_p_amount+3 }</option>
     					                                <option value="${basketVO.b_p_amount+4 }">${basketVO.b_p_amount+4 }</option>
		                                      		</c:if>
		                                      		<c:if test="${basketVO.b_p_amount eq 2}">
		                                      			<option value="${basketVO.b_p_amount-1 }">${basketVO.b_p_amount-1 }</option>
		                                      			<option value="${basketVO.b_p_amount }" selected>${basketVO.b_p_amount }</option>
		                                      			<option value="${basketVO.b_p_amount+1 }">${basketVO.b_p_amount+1 }</option>
		                                      			<option value="${basketVO.b_p_amount+2 }">${basketVO.b_p_amount+2 }</option>
		                                      			<option value="${basketVO.b_p_amount+3 }">${basketVO.b_p_amount+3 }</option>
		                                      		</c:if>
		                                      		<c:if test="${basketVO.b_p_amount ge 3}">
		                                      			<option value="${basketVO.b_p_amount-2 }">${basketVO.b_p_amount-2 }</option>
		                                      			<option value="${basketVO.b_p_amount-1 }">${basketVO.b_p_amount-1 }</option>
		                                      			<option value="${basketVO.b_p_amount }" selected>${basketVO.b_p_amount }</option>
		                                      			<option value="${basketVO.b_p_amount+1 }">${basketVO.b_p_amount+1 }</option>
		                                      			<option value="${basketVO.b_p_amount+2 }">${basketVO.b_p_amount+2 }</option>
		                                      		</c:if>
		                                      </select>
		                                      </form>
		                                      
		                                  </div>
		                              </td>
		                              <td>
		                                  <h5>
		                                  <c:set var="total"  value="${productVO.p_price }"/>
		                                  <price id="totalPrice"></price>
		                                  </h5>
		                              </td>
		                              <td>
		                              	<a href="#"><img src="${pageContext.request.contextPath }/resources/img/cart/delete.jpg" alt="" onclick="location.href='./basketDel?b_num=${basketVO.b_num}'"></a>
		                              </td>
		                          </tr>
		                         </c:if>
	                         </c:forEach>
                        </c:forEach>
						</c:otherwise>
					</c:choose>
						<!--  <tr>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td>
                                  <h5>Subtotal</h5>
                              </td>
                              <td>
                                  <h5 class="subtotal">$2160.00</h5>
                              </td>
                          </tr> -->
						<!-- <tr class="shipping_area">
                              <td class="d-none d-md-block"></td>
                              <td></td>
                              <td><h5><total-price>Shipping</total-price></h5></td>
                              <td><div class="shipping_box">
                                      <ul class="list">
                                          <li><a href="#">Flat Rate: $5.00</a></li>
                                          <li><a href="#">Free Shipping</a></li>
                                          <li><a href="#">Flat Rate: $10.00</a></li>
                                          <li class="active"><a href="#">Local Delivery: $2.00</a></li>
                                      </ul>
                                      <h6>Calculate Shipping <i class="fa fa-caret-down" aria-hidden="true"></i></h6>
                                      <select class="shipping_select">
                                          <option value="1">Bangladesh</option>
                                          <option value="2">India</option>
                                      </select>
                                      <select class="shipping_select">
                                          <option value="1">Select a State</option>
                                          <option value="4">Select a State</option>
                                      </select>
                                      <input type="text" placeholder="Postcode/Zipcode">
                                  </div>
                              </td>
                          </tr> -->
						<tr class="out_button_area">
                              <td class="d-none-l"></td>
                              <td class=""></td>
                              <td></td>
                              <td>
                                  <div class="checkout_btn_inner d-flex align-items-center">
                                      <a class="gray_btn" href="#">Continue Shopping</a>
                                      <a class="primary-btn ml-2" href="#">Proceed to checkout</a>
                                  </div>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
  </section> 

  <!--================End Cart Area =================-->

 
  <script>
	//javascript 체크박스 제어
	onload = function() {
		//전체선택 시 개별선택 전부 영향
		var chkAll = document.getElementById('chkAll'); //id가 chkAll인 것
		chkAll.addEventListener('click', function() {
			subtotal = 0;
			var chk_list = document.getElementsByClassName('chk'); //name이 chk인것들
			for (let i = 0; i < chk_list.length; i++) {
				chk_list[i].checked = chkAll.checked;
				
			}
		});
		
		//개별 선택이 전체 선택 결과에 영향
		var chk_list = document.getElementsByClassName('chk');
		for (let i = 0; i < chk_list.length; i++) {
			chk_list[i].addEventListener('click', function() {
				var chkAll = document.getElementById('chkAll');
				for (let j = 0; j < chk_list.length; j++) {
					
					if (chk_list[j].checked == false) { //checked 속성이 없다면
						chkAll.checked = false;
						return; //반복문탈출
					}
				}
				chkAll.checked = true;
			});
		}
	} //onready function
	
  </script>
  
  <script src="${pageContext.request.contextPath }/resources/vendors/jquery/jquery-3.2.1.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/vendors/bootstrap/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/vendors/skrollr.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/vendors/owl-carousel/owl.carousel.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/vendors/nice-select/jquery.nice-select.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/vendors/jquery.ajaxchimp.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/vendors/mail-script.js"></script>
  <script src="${pageContext.request.contextPath }/resources/js/main.js"></script>
<%@ include file="../include/footer.jsp" %>