<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>


	<!--single-page-->
	<div class="single-page main-grid-border">
		<div class="container">
			<ol class="breadcrumb" style="margin-bottom: 5px;">
				<li><a href="<spring:url value='/index' />">${home}</a></li>
				<li class="active"><a href="<spring:url value='/category/${category.translatedCategory.categoryId}' />">${category.categoryTranslation}</a></li>
				<li class="active">${product.name}</li>
			</ol>
			<div class="product-desc">
				<div class="col-md-7 product-view">
					<h2>${product.name}</h2>
					<p></p>
					<div class="flexslider">
						<ul class="slides">
						<c:forEach items="${images}" var="i">
							<li data-thumb="<spring:url value='/images/products/${i.path}' />">
								<img src="<spring:url value='/images/products/${i.path}' />" title="${i.name}" alt="${i.name}" />
							</li>
						</c:forEach>	
						</ul>
					</div>

					<!-- FlexSlider -->
					  <script defer src="<spring:url value='/js/jquery.flexslider.js' />"></script>
					<link rel="stylesheet" href="<spring:url value='/css/flexslider.css' />" type="text/css" media="screen" />

						<script>
					// Can also be used with $(document).ready()
					$(window).load(function() {
					  $('.flexslider').flexslider({
						animation: "slide",
						controlNav: "thumbnails"
					  });
					});
					</script>
					<!-- //FlexSlider -->
					<div class="product-details">
						
						<p><strong>${description}</strong> : ${product.description}</p>
						
						<p><strong>${qtInd}</strong> : ${product.quantityPerPack}</p>
						<h4>Ref : <strong>C${product.category.categoryId}A${product.productId}</strong></h4>
					</div>
				</div>
				<div class="col-md-5 product-details-grid">
					<div class="item-price">
						<div class="product-price">
							<p class="p-price">${price}</p>
							<h3 class="rate">€ ${product.unitPrice}</h3>
							<div class="clearfix"></div>
						</div>
						<div class="condition">
							<p class="p-price">${stock}</p>
							<c:choose>
							    <c:when test="${product.storedQuantity > 5}">
							        <h4>${instock}</h4>
							    </c:when>
							    <c:when test="${product.storedQuantity > 1}">
							        <h4>${lesstock} ${product.storedQuantity} !</h4>
							    </c:when>
							    <c:when test="${product.storedQuantity == 1}">
							        <h4>${laststock}</h4>
							    </c:when>
							    <c:otherwise>
							    	<h4>${outstock}</h4>
							    </c:otherwise>
							</c:choose>
							<div class="clearfix"></div>
						</div>
						<div class="itemtype">
							<p class="p-price">${type}</p>
							<h4>${category.categoryTranslation}</h4>
							<div class="clearfix"></div>
						</div>
					</div>
					<div class="interested text-center">
						<h4>${qt}</h4>
						<form:form 	id="form"
									method="POST"
									action="/ecommerce/single/send" modelAttribute="titi2">
							<p>
								<form:input type="number" path="nbArticles" min="1" max="${product.storedQuantity}" value="1" class="input-qt" id="input-qt" />
								<i class="glyphicon glyphicon-plus link" id="plus-qt"></i>
								<i class="glyphicon glyphicon-minus link" id="moins-qt"></i>
								
								<script type="text/javascript">
									var oldval = $("#input-qt").val();
									var enStock = ${product.storedQuantity};
								
									$("#plus-qt").on("click", function() {
										if(oldval < enStock)
									  		$("#input-qt").val(++oldval);
									});
									
									$("#moins-qt").on("click", function() {
										if(oldval > 1)
									  		$("#input-qt").val(--oldval);
									});
									
									$("#input-qt").on("change", function(){
										oldval = $("#input-qt").val();
										if(oldval > enStock)
											$("#input-qt").val(enStock);
										if(oldval < 1)
											$("#input-qt").val(1);
										oldval = $("#input-qt").val();
									});
									
								</script>
							</p>
							<p><button class="button-qt">${ajoutPanier}</button></p>
						</form:form>
					</div>
					<!-- div class="tips">
						<h4>Cet objet est fourni avec :</h4>
							<ol>
								<li>une fiole en verre avec bouchon de liège, contenant la poudre</li>
								<li>un certificat d'authenticité</li>
								<li>un parchemin racontant la découverte de cet artéfact</li>
							</ol>
					</div -->
				</div>
			<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--//single-page-->
	
