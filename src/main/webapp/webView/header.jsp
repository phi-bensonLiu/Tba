<%@ page contentType="text/html; charset=utf-8" language="java" %>
	<header>
		<div class="headerDiv">
			<div class="logoArea"><a href="#"><img src="assets/imgs/logo.gif"></a></div>
			<nav>
				<ul class="navMenu">
					<li><a href="#" class="dropdown-link" id="psclass"><i class="fa fa-bars" aria-hidden="true"></i> 課程專屬</a> </li>
					<li><a href="#">師資陣容</a></li>
				</ul>
			</nav>
		
		
			<div class="wap-fn">
				<div class="wap-members fl-l">
		            <a href="#" id="wap-login" onclick=" $('.wap-login').show()"><i class="fa fa-user"></i></a>
		            <div class="wap-login act">
			            <ul>
			                <li><a href="#">加入</a></li>
			                <li><a href="#">登入會員</a></li>
			            </ul>
		            </div>
	            </div>
	            
	            <button type="button" class="toggleNavMenu">
			        <i class="fa fa-bars" ></i>
		        </button>
			</div>
	            
	            



            <ul class="members">
                <li class="active">
	                <div class="fnArea">
			  
			            <div class="navSearchBox">
			                <form action="#" method="post">
			                    <div class="fieldset">
			                        <input type="text" name="something" id="something">
			                        <button><i class="fa fa-search" aria-hidden="true"></i></button>
			                    </div>
			                </form>
			            </div>
			        </div>
                </li>

                <li><a href="#">加入</a></li>

                <li><a href="#">登入會員</a></li>
            </ul>
 
		</div>
	</header>	
	<script>
	/*header 動作 */

	$(document).mouseup(function (e)
	{
		
		var navToggle = $( '#navbar' );
		var wapLogin = $('.wap-login');// 登入
		var nav1 =$('.n1'); // 次選單1
		var nav2 =$('.n2'); // 次選單1
		
	    var container = new Array();// 需要將開合的動作 關閉 陣列
	    //container.push($(".navMenu")); // 藏起來的
	    if ($(window).width() < 750) {
		    
		   container.push($(".navMenu")); // 藏起來的
		   //alert(1)
		}else{
			
			$(".navMenu").show();
		
		}
		
	    container.push(wapLogin);
	    container.push(nav1);
	    container.push(nav2);
	    
	    $.each(container, function(key, value) {
		    
	        if (!$(value).is(e.target) // if the target of the click isn't the container...
	        
	            && $(value).has(e.target).length === 0) // ... nor a descendant of the container
	        {
	            $(value).fadeOut(300); // 淡出
	            	            
	        }
	    });
	});
	
	
	
	/*
	$("#wap-login").click(function() {
		//wapLogin.show( "100" )
		wapLogin.slideToggle( '100' ).toggleClass('act')
		
	})*/
	
	var dropDtoggle = $("#psclass");// 下拉選單按鈕
	var menuA = $("#menuA") ;// 下拉選單
	var togMenu =$('.toggleNavMenu') ;// mobile 下拉選單
	
	togMenu.click(function() {
		
		$(".navMenu").show();
		
	});
	dropDtoggle.click(function() {
		
		menuA.slideToggle().toggleClass("in")
		
	});
	/*header 動作 fine*/	
	</script>

