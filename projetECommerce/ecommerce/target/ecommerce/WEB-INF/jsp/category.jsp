<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>

	<div class="categories">
		<div class="container">
			<c:forEach items="${categories}" var="c">
				<div class="col-md-2 focus-grid">
					<a href="<spring:url value='/category/${c.translatedCategory.categoryId}' />">
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
	<div class="total-ads main-grid-border">
		<div class="container">
			
			<ol class="breadcrumb" style="margin-bottom: 5px;">
			  <li><a href="<spring:url value='/index' />">${home}</a></li>
			  <li class="active">${category.categoryTranslation}</li>
			</ol>
			<div class="ads-grid">
				<div class="side-bar col-md-3">
					<div class="search-hotel">
					<h3 class="sear-head"><spring:message code="tout" /> ${category.categoryTranslation}</h3>
					<ul style="margin-left:30px;">
						<c:forEach items="${products}" var="p">
							<li><a href="<spring:url value='/single/${p.productId}' />">${p.name }</a></li>
						</c:forEach>
					</ul>
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
								<c:forEach items="${products}" var="p">
									<a href="<spring:url value='/single/${p.productId}' />">
										<li>
										<img src="<spring:url value='/images/products/${image[p.productId].path}' />" title="${image[p.productId].name}" alt="${image[p.productId].name}" />
										<section class="list-left">
										<h5 class="title">${p.name}</h5>
										<span class="adprice">€ ${p.unitPrice} <c:if test="${p.unitBasePrice != p.unitPrice}"><span class="promo">€ ${p.unitBasePrice}</span></c:if></span>
										</section>
										<section class="list-right">
										<span class="date">Ref : C${p.category.categoryId}A${p.productId}</span>
										<c:choose>
										    <c:when test="${p.storedQuantity > 0}">
										        <span class="cityname">${instock}</span>
										    </c:when>    
										    <c:otherwise>
										        <span class="cityname">${outstock}</span>
										    </c:otherwise>
										</c:choose>										
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
