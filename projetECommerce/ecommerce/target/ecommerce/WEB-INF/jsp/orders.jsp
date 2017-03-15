<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>
	
	<div class="total-ads main-grid-border">
		<div class="container">
			
			<div class="ads-grid">
				<div class="side-bar col-md-3">
					<div class="search-hotel">
					<h3 class="sear-head"><spring:message code="tout"/> <spring:message code="commande"/>s</h3>
					
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
									<ul class="list">
										<c:forEach items="${currentOrders}" var="order">
											<a href="<spring:url value='/order/${order.orderId}' />" >
												<li>
												<section class="list-left">
													<h5 class="title"><spring:message code="commande"/> n°${order.orderId}</h5>
													
													
												</section>
												<section class="list-right">
													<span class="date"><fmt:formatDate value="${order.orderDate}" pattern="dd/M/yyyy" /></span>
												</section>
												<div class="clearfix"></div>
												</li> 
											</a>
											
											
										</c:forEach>
									</ul>							
							
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
