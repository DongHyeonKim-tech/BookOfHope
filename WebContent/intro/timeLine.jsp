<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>희망의 책 소개</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Webestica.com">
<meta name="description"
	content="Creative Multipurpose Bootstrap Template">

<!-- Favicon -->
<link rel="shortcut icon" href="../assets/images/favicon.ico">

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900%7CPlayfair+Display:400,400i,700,700i%7CRoboto:400,400i,500,700"
	rel="stylesheet">

<!-- Plugins CSS -->
<link rel="stylesheet" type="text/css"
	href="../assets/vendor/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="../assets/vendor/themify-icons/css/themify-icons.css" />
<link rel="stylesheet" type="text/css"
	href="../assets/vendor/animate/animate.min.css" />

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css" href="../assets/css/style.css" />
</head>
<body>
	<header>
		<%@ include file="../include/header.jsp"%>
	</header>
	
		<!-- ======================	Banner innerpage -->
		<div class="left bg-grad pattern-overlay-4">
			<div class="container">
				<div class="row all-text-white">
					<div class="col-md-12 align-self-center">
						<h1 class="font-weight-bold display-4 display-md-1 mb-2 mb-md-n2 mt-9">연혁</h1>
					</div>
				</div>
			</div>
		</div>
		<!-- ======================= Banner innerpage -->
		
		<!-- ======================= blog -->
			<section class="blog-page pb-0">
				<div class="container">
					<div class="row">
						<!-- sidebar start -->
						<aside class="col-md-3 sidebar order-last order-md-first">
							<!-- 인사말 -->
							<div class="widget">
								<h3 class="widget-title"><a href="/notice?command=introAction">인사말</a></h3>
							</div>
		
							<!-- 연혁 -->
							<div class="widget widget-newsletter">
								<h3 class="widget-title">연혁</h3>
							</div>
		
							<!-- 조직도 -->
							<div class="widget widget-post">
								<h3 class="widget-title"><a href="/notice?command=teamAction">조직도</a></h3>
							</div>
		
							<!-- 찾아오시는 길 -->
							<div class="widget widget-post">
								<h3 class="widget-title"><a href="/notice?command=mapAction">찾아오시는 길</a></h3>
							</div>
							
							<c:if test="${LoginUser.authority ne null}">
							<div class="widget widget-post">
								<h3 class="widget-title"><a  href="/notice?command=noticeListFormAction">운영게시판</a></h3>
							</div>
							</c:if>
							
						</aside>
						<!-- sidebar end -->
						
						<!-- blog start -->
						<div class="col-md-9 mb-6 order-first order-md-first">
							<div class="text-center">
								<h3 class="mb-2">사람과의 만남이 중요하듯 또 다른 소중한 만남이 있습니다. <br><br> 바로 <span class="text-primary">책과의 만남</span>입니다.</h3>
							</div>
							
							<br><br><br>
							
								<!-- timeline item 1 -->
									<div class="row no-gutters">
									<div class="timeline-top"></div>
										<div class="col-md py-2">
											<div class="card">
												<div class="card-body">
													<h4 class="mb-2">● 2006년도</h4>
													<div class="list-group-number list-unstyled list-group-borderless">
														<a href="#" class="list-group-item list-group-item-action">
															<span>01</span>
															12월 28일 독서문화 진흥법 제정/공포</a>
													</div>
												</div>
											</div>
										</div>
						
										<div
											class="col-md-1 text-center timeline-line flex-column d-none d-md-flex">
											<div class="timeline-dot"></div>
										</div>
										<div class="col-sm"></div>
									</div>
									
							<!-- timeline item 2 -->
								<div class="row no-gutters">
									<div class="timeline-top"></div>
									<div class="col-md"></div>
									<div class="col-md-1 text-center timeline-line flex-column d-none d-md-flex">
										<div class="timeline-dot"></div>
									</div>
									<div class="col-md py-2">
										<div class="card">
											<div class="card-body">
												<h4 class="mb-2">● 2007년도</h4>
												<div class="list-group-number list-unstyled list-group-borderless">
													<a href="#" class="list-group-item list-group-item-action">
															<span>01</span>
															4월 5일 독서문화진흥법 본격 시행</a> <a href="#"
															class="list-group-item list-group-item-action">
															<span>02</span>
															4월19일 대전광역시 『책 읽는 대전 운동 종합계획』수립및 22개 실천과제발굴 각급기관 및 단체에 참여와 협조
															요청</a> <a href="#" class="list-group-item list-group-item-action">
															<span>03</span>
															4월23일 대전시장의요청에 따라 한국문화원연합회 대전광역시지회에서는 지역문화원, 도서관, 시민단체가 협력을 통해
															책 읽는 운동을 지역문화운동으로 발전을 위한추진본부 구성 추진 </a> 
															<a href="#" class="list-group-item list-group-item-action">
															<span>04</span>
															6월7일 한국문화원연합회대전지회(지회장조성남), 대전사랑시민협의회(회장 양희권), 대전참여자치시민연대(공동의장송인준), 한국문인협회대전지회(회장 이규식), 대전여성단체협의회(회장장금식), 
															대전YMCA(사무총장 이충재) 6개 대전시민사회단체가 창립준비모임을통해 추진본부 조직구성 창립대회 일정, 운영규약, 책 읽는 대전운동선언문 등 기본(안)마련</a>
															
															<a href="#" class="list-group-item list-group-item-action">
															<span>05</span>
															7월24일 「책읽는 대전운동」 명칭공모를 통해 명칭은 희망의 책 대전본부로슬로건은 “책으로 행복한 대전”으로
															확정하고 「희망의 책 대전본부」출범식과 “책으로 행복한 대전” 선포식 진행</a>
															
															<a href="#" class="list-group-item list-group-item-action">
															<span>06</span>
															7월24일 희망의 책 대전본부 출범이후 보다 효율적인 사업추진과 범시민적 참여와본부의 공공성과 신뢰성을 강화하기 
															위해 다각적인 모색 후 제4차 공동대표회의(10/9)와발기인대회(10/9) 를 통해 지역네트워크를 통한 민간 참여강화와 민간중심의거버넌스 강화를 위해 법인화를 결정</a>
															
															<a href="#" class="list-group-item list-group-item-action">
															<span>07</span>
															10월23일 사단법인 희망의 책 대전본부 창립총회 - 조성남 본 회의 이사장으로 추대</a>
															
															<a href="#" class="list-group-item list-group-item-action">
															<span>08</span>
															11월26일 사단법인 희망의 책 대전본부 법인설립허가</a>
															
															<a href="#" class="list-group-item list-group-item-action">
															<span>09</span>
															12월12일 사단법인 희망의 책 대전본부 법인설립허가증 발급</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								<!-- timeline item 3 -->
									<div class="row no-gutters">
										<div class="col-md py-2">
											<div class="card">
												<div class="card-body">
													<h4 class="mb-2">● 2008년도</h4>
													<div class="list-group-number list-unstyled list-group-borderless">
														<a href="#" class="list-group-item list-group-item-action">
															<span>01</span>
															1월29일 2008년도 정기총회 개최 </a>
													</div>
												</div>
											</div>
										</div>
						
										<div
											class="col-md-1 text-center timeline-line flex-column d-none d-md-flex">
											<div class="timeline-dot"></div>
										</div>
										<div class="col-sm"></div>
									</div>
									
									<!-- timeline item 4 -->
										<div class="row no-gutters">
											<div class="timeline-top"></div>
											<div class="col-md"></div>
											<div
												class="col-md-1 text-center timeline-line flex-column d-none d-md-flex">
												<div class="timeline-dot"></div>
											</div>
											<div class="col-md py-2">
												<div class="card">
													<div class="card-body">
														<h4 class="mb-2">● 2009년도</h4>
														<div
															class="list-group-number list-unstyled list-group-borderless">
															<a href="#" class="list-group-item list-group-item-action"><span>01</span>
																2월25일 2009년도 정기총회 개최 </a>
														</div>
													</div>
												</div>
											</div>
										</div>
										
									<!-- timeline item 5 -->
									<div class="row no-gutters">
										<div class="col-md py-2">
											<div class="card">
												<div class="card-body">
													<h4 class="mb-2">● 2010년도</h4>
													<div class="list-group-number list-unstyled list-group-borderless">
														<a href="#" class="list-group-item list-group-item-action">
															<span>01</span>
															3월25일 2010년도 정기총회 개최 </a>
															
														<a href="#" class="list-group-item list-group-item-action">
															<span>02</span>
															11월12일 2010년도 임시총회 개최, <br>조성남 이사장을 본회 이사장으로 재추대   </a>
													</div>
												</div>
											</div>
										</div>
						
										<div
											class="col-md-1 text-center timeline-line flex-column d-none d-md-flex">
											<div class="timeline-dot"></div>
										</div>
										<div class="col-sm"></div>
									</div>
									
									<!-- timeline item 6 -->
										<div class="row no-gutters">
											<div class="timeline-top"></div>
											<div class="col-md"></div>
											<div
												class="col-md-1 text-center timeline-line flex-column d-none d-md-flex">
												<div class="timeline-dot"></div>
											</div>
											<div class="col-md py-2">
												<div class="card">
													<div class="card-body">
														<h4 class="mb-2">● 2011년도</h4>
														<div
															class="list-group-number list-unstyled list-group-borderless">
															<a href="#" class="list-group-item list-group-item-action"><span>01</span>
																2월24일 2011년도 정기총회 개최 </a>
														</div>
													</div>
												</div>
											</div>
										</div>
										
									<!-- timeline item 7 -->
									<div class="row no-gutters">
										<div class="col-md py-2">
											<div class="card">
												<div class="card-body">
													<h4 class="mb-2">● 2012년도</h4>
													<div class="list-group-number list-unstyled list-group-borderless">
														<a href="#" class="list-group-item list-group-item-action">
															<span>01</span>
															3월14일 2012년도 정기총회 개최  </a>
															
													</div>
												</div>
											</div>
										</div>
						
										<div
											class="col-md-1 text-center timeline-line flex-column d-none d-md-flex">
											<div class="timeline-dot"></div>
										</div>
										<div class="col-sm"></div>
									</div>
									
									<!-- timeline item 8 -->
										<div class="row no-gutters">
											<div class="timeline-top"></div>
											<div class="col-md"></div>
											<div
												class="col-md-1 text-center timeline-line flex-column d-none d-md-flex">
												<div class="timeline-dot"></div>
											</div>
											<div class="col-md py-2">
												<div class="card">
													<div class="card-body">
														<h4 class="mb-2">● 2013년도</h4>
														<div
															class="list-group-number list-unstyled list-group-borderless">
															<a href="#" class="list-group-item list-group-item-action"><span>01</span>
																3월15일 2013년도 정기총회 개최 </a>
														</div>
													</div>
												</div>
											</div>
										</div>
										
									<!-- timeline item 9 -->
									<div class="row no-gutters">
										<div class="col-md py-2">
											<div class="card">
												<div class="card-body">
													<h4 class="mb-2">● 2014년도</h4>
													<div class="list-group-number list-unstyled list-group-borderless">
														<a href="#" class="list-group-item list-group-item-action">
															<span>01</span>
															3월20일 2014년도 정기총회 개최 </a>
															
														<a href="#" class="list-group-item list-group-item-action">
															<span>02</span>
															5월29일 2014년도 임시총회 개최, <br>조성남 이사장을 본회 이사장으로 재추대   </a>
													</div>
												</div>
											</div>
										</div>
						
										<div
											class="col-md-1 text-center timeline-line flex-column d-none d-md-flex">
											<div class="timeline-dot"></div>
										</div>
										<div class="col-sm"></div>
									</div>
									
									<!-- timeline item 10 -->
<!-- 										<div class="row no-gutters">
											<div class="timeline-top"></div>
											<div class="col-md"></div>
											<div
												class="col-md-1 text-center timeline-line flex-column d-none d-md-flex">
												<div class="timeline-dot"></div>
											</div>
											<div class="col-md py-2">
												<div class="card">
													<div class="card-body">
														<h4 class="mb-2">● ????년도</h4>
														<div
															class="list-group-number list-unstyled list-group-borderless">
															<a href="#" class="list-group-item list-group-item-action">
															<span>01</span>
																1번항목 </a>
																
															<a href="#" class="list-group-item list-group-item-action">
															<span>02</span>
																2번 항목 </a>	
															
														</div>
														
														
													</div>
												</div>
											</div> -->
										</div>
									
						</div>
				
			</div>
		</div>
		</section>
	
	<footer>
		<%@ include file="../include/footer.jsp"%>
	</footer>

</body>
</html>