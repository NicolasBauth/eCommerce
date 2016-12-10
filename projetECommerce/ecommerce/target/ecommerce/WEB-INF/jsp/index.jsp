<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>

<!-- content-starts-here -->
		<div class="content">
			<div class="categories">
				<div class="container">
					<div class="col-md-2 focus-grid">
						<a href="<spring:url value='categorie' />">
							<div class="focus-border">
								<div class="focus-layout"> 
									<div class="focus-image"><i class="fa fa-flask"></i></div>
									<h4 class="clrchg">Potions et Poudres</h4>
								</div>
							</div>
						</a>
					</div>
					<div class="col-md-2 focus-grid">
						<a href="categorie">
							<div class="focus-border">
								<div class="focus-layout">
									<div class="focus-image"><i class="fa fa-diamond"></i></div>
									<h4 class="clrchg">Pierres Précieuses et Oeufs</h4>
								</div>
							</div>
						</a>
					</div>	
					<div class="col-md-2 focus-grid">
						<a href="categorie">
							<div class="focus-border">
								<div class="focus-layout">
									<div class="focus-image"><i class="fa fa-key"></i></div>
									<h4 class="clrchg">Objets uniques</h4>
								</div>
							</div>
						</a>
					</div>	
					<div class="col-md-2 focus-grid">
						<a href="categorie">
							<div class="focus-border">
								<div class="focus-layout">
									<div class="focus-image"><i class="fa fa-magic"></i></div>
									<h4 class="clrchg">Baguettes Magiques</h4>
								</div>
							</div>
						</a>
					</div>		
					<div class="col-md-2 focus-grid">
						<a href="categorie">
							<div class="focus-border">
								<div class="focus-layout">
									<div class="focus-image"><i class="fa fa-book"></i></div>
									<h4 class="clrchg">Grimoires et Parchemins</h4>
								</div>
							</div>
						</a>
					</div>	
					<div class="col-md-2 focus-grid">
						<a href="categorie">
							<div class="focus-border">
								<div class="focus-layout">
									<div class="focus-image"><i class="fa fa-leaf"></i></div>
									<h4 class="clrchg">Plantes et Champignons</h4>
								</div>
							</div>
						</a>
					</div>	
					
			</div>
			<div class="trending-ads">
				<div class="container">
				<!-- slider -->
				<div class="trend-ads">
					<h2>Nouveautés</h2>
					${lastProducts}
					<ul><c:forEach var="nom"  items="${lastProducts}">
 
						          <li>${nom}<li/>
						</c:forEach>
						</ul>
						
						<c:choose>
						  <c:when test="${empty lastProducts}">
						    pas d'information
						  </c:when>
						  <c:otherwise>
						    <c:forEach items="${lastProducts}" var="p">
						      ${p.name}
						    </c:forEach>
						  </c:otherwise>
						</c:choose>
						
							<ul id="flexiselDemo3">
								<li>
									<div class="col-md-3 biseller-column">
										<a href="single.html">
											<img src="images/poudre-de-dragon.jpg"/>
											<span class="price">&#8364; 14,50</span>
										</a> 
										<div class="ad-info">
											<h5>Poudre de dragon</h5>
										</div>
									</div>
									<div class="col-md-3 biseller-column">
										<a href="single.html">
											<img src="images/poudre-de-dragon.jpg"/>
											<span class="price">&#8364; 14,50</span>
										</a> 
										<div class="ad-info">
											<h5>Poudre de dragon</h5>
										</div>
									</div>
									<div class="col-md-3 biseller-column">
										<a href="single.html">
											<img src="images/poudre-de-dragon.jpg"/>
											<span class="price">&#8364; 14,50</span>
										</a> 
										<div class="ad-info">
											<h5>Poudre de dragon</h5>
										</div>
									</div>
									<div class="col-md-3 biseller-column">
										<a href="single.html">
											<img src="images/poudre-de-dragon.jpg"/>
											<span class="price">&#8364; 14,50</span>
										</a> 
										<div class="ad-info">
											<h5>Poudre de dragon</h5>
										</div>
									</div>
								</li>
								<li>
									<div class="col-md-3 biseller-column">
										<a href="single.html">
											<img src="images/poudre-de-dragon.jpg"/>
											<span class="price">&#8364; 14,50</span>
										</a> 
										<div class="ad-info">
											<h5>Poudre de dragon</h5>
										</div>
									</div>
									<div class="col-md-3 biseller-column">
										<a href="single.html">
											<img src="images/poudre-de-dragon.jpg"/>
											<span class="price">&#8364; 14,50</span>
										</a> 
										<div class="ad-info">
											<h5>Poudre de dragon</h5>
										</div>
									</div>
									<div class="col-md-3 biseller-column">
										<a href="single.html">
											<img src="images/poudre-de-dragon.jpg"/>
											<span class="price">&#8364; 14,50</span>
										</a> 
										<div class="ad-info">
											<h5>Poudre de dragon</h5>
										</div>
									</div>
									<div class="col-md-3 biseller-column">
										<a href="single.html">
											<img src="images/poudre-de-dragon.jpg"/>
											<span class="price">&#8364; 14,50</span>
										</a> 
										<div class="ad-info">
											<h5>Poudre de dragon</h5>
										</div>
									</div>
									
								</li>
								<li>
									<div class="col-md-3 biseller-column">
										<a href="single.html">
											<img src="images/poudre-de-dragon.jpg"/>
											<span class="price">&#8364; 14,50</span>
										</a> 
										<div class="ad-info">
											<h5>Poudre de dragon</h5>
										</div>
									</div>
									<div class="col-md-3 biseller-column">
										<a href="single.html">
											<img src="images/poudre-de-dragon.jpg"/>
											<span class="price">&#8364; 14,50</span>
										</a> 
										<div class="ad-info">
											<h5>Poudre de dragon</h5>
										</div>
									</div>
									<div class="col-md-3 biseller-column">
										<a href="single.html">
											<img src="images/poudre-de-dragon.jpg"/>
											<span class="price">&#8364; 14,50</span>
										</a> 
										<div class="ad-info">
											<h5>Poudre de dragon</h5>
										</div>
									</div>
									<div class="col-md-3 biseller-column">
										<a href="single.html">
											<img src="images/poudre-de-dragon.jpg"/>
											<span class="price">&#8364; 14,50</span>
										</a> 
										<div class="ad-info">
											<h5>Poudre de dragon</h5>
										</div>
									</div>
									
								</li>
						</ul>
					<script type="text/javascript">
						 $(window).load(function() {
							$("#flexiselDemo3").flexisel({
								visibleItems:1,
								animationSpeed: 1000,
								autoPlay: true,
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
		