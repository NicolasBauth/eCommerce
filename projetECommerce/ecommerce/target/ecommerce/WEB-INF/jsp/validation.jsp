<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>
	
	<div class="total-ads main-grid-border">
		<div class="container">
			
			<div class="ads-grid">
				<div class="side-bar col-md-3">
					<div class="search-hotel">
					<h3 class="sear-head"><spring:message code="total" /></h3>
					<h3 class="sear-head">€ ${prixTotal}</h3>
					
					<p><button class="button-qt" onclick="location.replace('<spring:url value='/order/order' />')"><spring:message code="commander" /></button></p>
					
				</div>
				
				
				
				</div>
				<div class="ads-display col-md-9">
					<div class="wrapper">					
					<div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
					  
					  <div id="myTabContent" class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="home" aria-labelledby="home-tab">
						   <div>
							<div id="container">
								
								<div class="clearfix"></div>
							<c:choose>
								<c:when test="${not empty currentCart}">
									<ul class="list">
										<c:forEach items="${products}" var="p">
											<a href="<spring:url value='/single/${p.productId}' />" >
												<li>
												<img src="../images/products/${image[p.productId].path}" title="${image[p.productId].name}" alt="${image[p.productId].name}" />
												<section class="list-left">
												<h5 class="title">${p.name}</h5>
												<span class="adprice">€ ${p.unitPrice * currentCart[p.productId] }</span>
												
												</section>
												<section class="list-right">
												<span class="date">Ref : C${p.category.categoryId}A${p.productId}</span>
												<span class="cityname">€ ${p.unitPrice}</span>							
												</section>
												<div class="clearfix"></div>
												</li> 
											</a>
										</c:forEach>
									</ul>
								</c:when>
								<c:otherwise>
									<h4>${emptyCart }</h4>
								</c:otherwise>
							</c:choose>
							
							
						</div>
							</div>
						</div>
						
					</div>
				</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>	
	</div>
</div>
