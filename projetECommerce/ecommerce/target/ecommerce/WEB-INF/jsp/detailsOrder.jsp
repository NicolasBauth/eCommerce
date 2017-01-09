<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>
	
	<div class="total-ads main-grid-border">
		<div class="container">
			
			<div class="ads-grid">
				<div class="side-bar col-md-3">
					<div class="search-hotel">
					<h3 class="sear-head">Payer</h3>
					
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
                                        ${order.orderId}  ${order.orderDate}
										<c:forEach items="${order.orderLines}" var="line">
											<a href="<spring:url value='/single/${line.orderedProduct.productId}' />" >
												<li>
												<img src="images/products/${image[line.orderedProduct.productId].path}" title="${image[line.orderedProduct.productId].name}" alt="${image[line.orderedProduct.productId].name}" />
												<section class="list-left">
												<h5 class="title">${line.orderedProduct.name}</h5>
												<span class="adprice">€ ${line.unitPrice}</span>
												</section>
												<section class="list-right">
												<span class="date">Ref : C${line.orderedProduct.category.categoryId}A${line.orderedProduct.productId}</span>
    									        <span class="cityname">Quantité commandée ${line.quantity}</span>
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
