<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>


	<!--single-page-->
	<div class="single-page main-grid-border">
		<div class="container">
			<ol class="breadcrumb" style="margin-bottom: 5px;">
				<li><a href="index.html">Accueil</a></li>
				<li class="active"><a href="mobiles.html">Poudres et Potions</a></li>
				<li class="active">Poudre de dragon</li>
			</ol>
			<div class="product-desc">
				<div class="col-md-7 product-view">
					<h2>Poudre de dragon</h2>
					<p></p>
					<div class="flexslider">
						<ul class="slides">
							<li data-thumb="images/poudre-de-dragon.jpg">
								<img src="images/poudre-de-dragon.jpg" />
							</li>
							
						</ul>
					</div>
					<!-- FlexSlider -->
					  <script defer src="js/jquery.flexslider.js"></script>
					<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

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
						
						<p><strong>Description</strong> : Véritable poudre de dragon. Objet indispensable et difficile à trouver.</p>
						
						<p><strong>Quantité individuelle	</strong> : 15 gr.</p>
						<h4>Ref : <strong>MA0154</strong></h4>
					</div>
				</div>
				<div class="col-md-5 product-details-grid">
					<div class="item-price">
						<div class="product-price">
							<p class="p-price">Prix</p>
							<h3 class="rate">€ 14,50</h3>
							<div class="clearfix"></div>
						</div>
						<div class="condition">
							<p class="p-price">Stock</p>
							<h4>Disponible</h4>
							<div class="clearfix"></div>
						</div>
						<div class="itemtype">
							<p class="p-price">Type</p>
							<h4>Poudre</h4>
							<div class="clearfix"></div>
						</div>
					</div>
					<div class="interested text-center">
						<h4>Quantité</h4>
						<form>
							<p><input type="number" min="1" class="input-qt"><i class="glyphicon glyphicon-plus"></i><i class="glyphicon glyphicon-minus"></i></p>
							<p><button class="button-qt">Ajouter au panier</button></p>
						</form>
					</div>
						<div class="tips">
						<h4>Cet objet est fourni avec :</h4>
							<ol>
								<li>une fiole en verre avec bouchon de liège, contenant la poudre</li>
								<li>un certificat d'authenticité</li>
								<li>un parchemin racontant la découverte de cet artéfact</li>
							</ol>
						</div>
				</div>
			<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--//single-page-->
	
