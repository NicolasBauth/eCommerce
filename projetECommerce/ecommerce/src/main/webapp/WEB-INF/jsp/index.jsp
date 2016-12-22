<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>

<!-- content-starts-here -->
		<div class="content">
			<div class="categories">
				<div class="container">
					<c:forEach items="${categories}" var="c">
						<div class="col-md-2 focus-grid">
							<spring:url var="category" value="">
								<spring:param name="category" value="${c.translatedCategory.categoryId}"/>
							</spring:url>
							<a href="category${category}">
								<div class="focus-border">
									<div class="focus-layout">
										<div class="focus-image"><i class="fa fa-${c.translatedCategory.icon}"></i></div>
										<h4 class="clrchg">${c.categoryTranslation}</h4>
									</div>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="trending-ads">
				<div class="container">
				<!-- slider -->
				<div class="trend-ads" id="news">
					<h2>Nouveautés</h2>
					
					<c:forEach items="${productsCat1}" var="t">
						${t.name}
					</c:forEach>
						
						<ul id="flexiselDemo3">
							<% int i = 0; %>
							<c:forEach items="${lastProducts}" var="p">
							<% if(i == 0 || i%4 == 0){ %> <li> <% } %>
								<div class="col-md-3 biseller-column">
									<a href="single.html?product=${p.productId}">
										
										<img src="images/products/${imageProduct[p.productId].path}"/ title="${imageProduct[p.productId].name}" alt="${imageProduct[p.productId].name}">
										<span class="price">&#8364; ${p.unitPrice}</span>
									</a> 
									<div class="ad-info">
										<h5>${p.name}</h5>
									</div>
								</div>
							<% i++; if(i%4 == 0){ %> </li> <% } %>
							</c:forEach>
							</li>
						</ul>
					<script type="text/javascript">
						 $(window).load(function() {
							$("#flexiselDemo3").flexisel({
								visibleItems:1,
								animationSpeed: 1000,
								autoPlay: false,
								autoPlaySpeed: 5000,    		
								pauseOnHover: true,
								enableResponsiveBreakpoints: true,
								responsiveBreakpoints: { 
									portrait: { 
										changePoint:480,
										visibleItems:1
									}, 
									landscape: { 
										changePoint:640,
										visibleItems:1
									},
									tablet: { 
										changePoint:768,
										visibleItems:1
									}
								}
							});
							
						});
					   </script>
					   <script type="text/javascript" src="js/jquery.flexisel.js"></script>
					</div>   
			</div>
			<!-- //slider -->				
			</div>
			
		</div>
		