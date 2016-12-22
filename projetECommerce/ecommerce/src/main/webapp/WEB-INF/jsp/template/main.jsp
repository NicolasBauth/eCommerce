<%@ include file="../include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>



<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Magicabrac | Home</title>

<link rel="stylesheet" href="<spring:url value='/css/bootstrap.min.css' />">
<link rel="stylesheet" href="<spring:url value='/css/bootstrap-select.css' />" >
<link rel="stylesheet" href="<spring:url value='/css/style.css' />" type="text/css" media="all" />
<link rel="stylesheet" href="<spring:url value='/css/flexslider.css' />" type="text/css" media="screen" />
<link rel="stylesheet" href="<spring:url value='/css/font-awesome.min.css' />" />
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Ubuntu+Condensed' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!--//fonts-->	
<!-- js -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- js -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<spring:url value='/js/bootstrap.min.js' />"></script>
<script src="<spring:url value='/js/bootstrap-select.js' />"></script>
<script>
  $(document).ready(function () {
    var mySelect = $('#first-disabled2');

    $('#special').on('click', function () {
      mySelect.find('option:selected').prop('disabled', true);
      mySelect.selectpicker('refresh');
    });

    $('#special2').on('click', function () {
      mySelect.find('option:disabled').prop('disabled', false);
      mySelect.selectpicker('refresh');
    });

    $('#basic2').selectpicker({
      liveSearch: true,
      maxOptions: 1
    });
  });
</script>
<script type="text/javascript" src="<spring:url value='/js/jquery.leanModal.min.js' />"></script>
<link href="<spring:url value='/css/jquery.uls.css' />" rel="stylesheet"/>
<link href="<spring:url value='/css/jquery.uls.grid.css' />" rel="stylesheet"/>
<link href="<spring:url value='/css/jquery.uls.lcd.css' />" rel="stylesheet"/>
<!-- Source -->
<script src="<spring:url value='/js/jquery.uls.data.js' />"></script>
<script src="<spring:url value='/js/jquery.uls.data.utils.js' />"></script>
<script src="<spring:url value='/js/jquery.uls.lcd.js' />"></script>
<script src="<spring:url value='/js/jquery.uls.languagefilter.js' />"></script>
<script src="<spring:url value='/js/jquery.uls.regionfilter.js' />"></script>
<script src="<spring:url value='/js/jquery.uls.core.js' />"></script>
<script>
			$( document ).ready( function() {
				$( '.uls-trigger' ).uls( {
					onSelect : function( language ) {
						var languageName = $.uls.data.getAutonym( language );
						$( '.uls-trigger' ).text( languageName );
					},
					quickList: ['en', 'hi', 'he', 'ml', 'ta', 'fr'] //FIXME
				} );
			} );
		</script>
</head>
<body>
	<div class="header">
		<div class="container">
			<div class="logo">
				<a href="index"><span>Magic</span>abrac</a>
			</div>
			<div class="header-right">
				<a class="account" href=""><i class="glyphicon glyphicon-shopping-cart"></i> 0 article(s)</a>
				<a class="login" href="login"><i class="glyphicon glyphicon-user"></i></a>
				<spring:url var="localeFr" value="">
					<spring:param name="locale" value="fr"/>
				</spring:url>
				
				<spring:url var="localeEng" value="">
					<spring:param name="locale" value="eng"/>
				</spring:url>
				
				<spring:url var="localeDe" value="">
					<spring:param name="locale" value="de"/>
				</spring:url>
				
				<a href="${localeDe}"><span class="lng-sprite all">Allemand</span></a>
				<a href="${localeEng}"><span class="lng-sprite ngl">Anglais</span></a>
				<a href="${localeFr}"><span class="lng-sprite fr">Français</span></a>
				
		
			</div>
		</div>
	</div>
	<div class="main-banner banner text-center">
	  <div class="container">    
			<h1><spring:message code="bannerMainText"/></h1>
			<p><spring:message code="bannerSecText"/></p>
			<a href="index#news"><spring:message code="bannerCatalogue"/></a>
	  </div>
	</div>
		
	<tiles:insertAttribute name="main-content" />
	
	<!--footer section start-->		
		<footer>
			<div class="footer-top">
				<div class="container">
					<div class="foo-grids">
						<div class="col-md-3 footer-grid">
							<h4 class="footer-head">Qui sommes-nous?</h4>
							<p>Nous sommes l'unique magasin de magie professionnel en ligne qui propose des objets uniques et rare. <br/>
							Nous sélectionnons pour vous les meilleurs produits de magie.</p>
						</div>
						<div class="col-md-3 footer-grid">
							<h4 class="footer-head">Aide</h4>
							<ul>
								<li><a href="sitemap">Plan du site</a></li>
								<li><a href="faq">Faq</a></li>
								<!-- li><a href="contact.html">Contact</a></li -->
							</ul>
						</div>
						<div class="col-md-3 footer-grid">
							<h4 class="footer-head">Information</h4>
							<ul>
								<li><a href="terms">Conditions d'utilisations</a></li>
								<li><a href="livraison">Livraison, expédition et retour</a></li>	
								<li><a href="privacy">Politique de confidentialité</a></li>	
							</ul>
						</div>
						<div class="col-md-3 footer-grid">
							<h4 class="footer-head">Nous contacter</h4>
							<address>
								<ul class="location">
									<li><span class="glyphicon glyphicon-map-marker"></span></li>
									<li>1 Place Wiertz, 5000 Namur (Belgique)</li>
									<div class="clearfix"></div>
								</ul>	
								<ul class="location">
									<li><span class="glyphicon glyphicon-earphone"></span></li>
									<li>+32 81 75 75 65</li>
									<div class="clearfix"></div>
								</ul>	
								<ul class="location">
									<li><span class="glyphicon glyphicon-envelope"></span></li>
									<li><a href="mailto:info@magicabrac.com">info@magicabrac.com</a></li>
									<div class="clearfix"></div>
								</ul>						
							</address>
						</div>
						<div class="clearfix"></div>
					</div>						
				</div>	
			</div>	
			<div class="footer-bottom text-center">
			<div class="container">
				<div class="footer-logo">
					<a href="index"><span>Magic</span>abrac</a>
				</div>
				<div class="footer-social-icons">
					<ul>
						<li><a class="facebook" href="#"><span>Facebook</span></a></li>
						<li><a class="twitter" href="#"><span>Twitter</span></a></li>
						<li><a class="googleplus" href="#"><span>Google+</span></a></li>
					</ul>
				</div>
				<div class="copyrights">
					<p> © 2016 Magicabrac. Tous droits réservés | Design by  <a href="http://w3layouts.com/" about="_blank"> W3layouts</a></p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		</footer>
        <!--footer section end-->
        
</body>
</html>