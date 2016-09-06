//針對螢幕大小去做動作

/* 99
if ($(window).width() < 750) {
   //alert('Less than 960');
  
}
else {
   getmakeFixed();
   
}*/

$(document).ready(function () {
		
	navScheduleTab();// tab eff

    //平滑移動
    
    if ($(window).width() < 750) { 
	    var dd = new DropDown( jQuery('.nav-a') ); // 下拉選單 動作
	    
    }
    
	jQuery(document).click(function() {
		// all dropdowns
		jQuery('.dropWrap').removeClass('act');
		
	
	})
	
	//setTimeout(function(){  $('#btnPopup').click(); 	 }, 1000);
		
		
})

/*header 動作 */
	var  navToggle = $( '#navbar' );
	var  wapLogin = $('.wap-login');
	
	$(document).mouseup(function (e)
	{
	    var container = new Array();// 需要將開合的動作 關閉 陣列
	    //container.push($(".navMenu")); // 藏起來的
	    if ($(window).width() < 640) {
		   container.push($(".navMenu")); // 藏起來的
		}
	    container.push(wapLogin);
	    
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
	

// tab function
	
	function navScheduleTab(){
		var _showTab = 0;
		var $defaultLi = $('ul.nav-schedule li').eq(_showTab).addClass('active');
		$($defaultLi.find('a').attr('href')).siblings().hide();
		
		// 當 li 頁籤被點擊時...
		// 若要改成滑鼠移到 li 頁籤就切換時, 把 click 改成 mouseover
		$('ul.nav-schedule li:not(.out)').click(function() {
			// 找出 li 中的超連結 href(#id)
			var $this = $(this),
				_clickTab = $this.find('a').attr('href');
			// 把目前點擊到的 li 頁籤加上 .active
			// 並把兄弟元素中有 .active 的都移除 class
			$this.addClass('active').siblings('.active').removeClass('active');
			// 淡入相對應的內容並隱藏兄弟元素
			$(_clickTab).stop(false, true).fadeIn().siblings().hide();
			
			//回傳改變標題文字
			var dayNum = $('.active h4').attr( "title" );;
			//var dayNum =  $('.highlight h4').text( "1");
			$("#highlight").text(dayNum)
		
			$('.dropWrap').removeClass('act');
			
			//alert("1");
			return false;
		}).find('a').focus(function(){
			this.blur();
		});
		
	}

// tab function fine

//平滑移動
	$('.smoothClick').click(function() {
			
	    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
	
	      var target = jQuery(this.hash);
	      
	      target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
	      
	      if (target.length) {
	       
	        $('html,body').animate({
	         
	          scrollTop: target.offset().top
	          
	        }, 700);
	        
	        return false;
	        
	      }
	      
	    };
	    
	    
	});//平滑移動

    $('#ankClick').click(function(){
	    
	    $('.smoothClick').click();
	    
    })
    
    

//平滑移動


/*移動定住效果*/
	/*移動定住效果*/
	
	/* 99
	function getmakeFixed(){
		
		var sposit = $("#sticker");
		var anker = $("#stickerAnk");//錨點
		var noteNavBar =$('.noteNavBar')
		var pos = anker.position();
						   
		$(window).scroll(function() {
			
			var windowpos = $(window).scrollTop();
			//s.html("Distance from top:" + pos.top + "<br />Scroll position: " + windowpos);
			if (windowpos >= pos.top) {
				
				sposit.addClass("stick");
				noteNavBar.addClass('active')
				//$('.smoothClick').click();
				
			} else {
				sposit.removeClass("stick");
				noteNavBar.removeClass('active')
				$('.videoCont').css("height","auto")
				
				
			}
			
		});

			
	}*/
	
	videoContSize()
	
	function videoContSize(){
		//var videoCont = $('.videoCont');
		var videoCont = $('.rwd-video');
		var orgHeight = videoCont.height();
		var newHeight = Number(orgHeight);
		
		$('.videoCont').css("min-height",newHeight);
		
		
	     //console.log(newHeight);
		

	}
/*移動定住效果*/		

//視窗切換＆下拉 手機版
	function DropDown(el) {
		this.dd = el;
		this.initEvents();
	}
	
	DropDown.prototype = {
		initEvents : function() {
			var obj = this;

			obj.dd.click(function(event){
				jQuery(this).toggleClass('act');
				event.stopPropagation();
			});	
		}
	}


//pop視窗 set
	function openPopup(){
		$.magnificPopup.open({
			items: {
			  src: '#popup',
    		}, 
			mainClass: 'mfp-newspaper'
    });
    $("#btnPopup").attr("disabled", false);
	}


	function closePopup(){
		
		$('mfp-close').click();	
	}
		
//pop視窗 fine
