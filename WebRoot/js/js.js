
$("body").ready(function() {
			$("#tDate").val("1990-01-01");
			$("#tDate").jSelectDate({
				yearBeign : 1960,
				disabled : false
			});
			

			$('.delete').click(function(){
				
				/*var elem = $(this).closest('.item');*/
				var rsid = $("#rsid").val();
				$.confirm({
					'title'		: '确认删除',
					'message'	: '你正在删除一个居民，确定要删除吗?',
					'buttons'	: {
						'确定'	: {
							'class'	: 'blue',
							'action': function(){
								window.location.href='LogoutResident?rsid=' + rsid;
								elem.slideUp();
							}
						},
						'取消'	: {
							'class'	: 'gray',
							'action': function(){}	// Nothing to do in this case. You can as well omit the action property.
						}
					}
				});
				
			});
			
			$('.checkin').click(function(){
				
				/*var elem = $(this).closest('.item');*/
				var rsid = $("#rsid").val();
				$.confirm({
					'title'		: '确认删除',
					'message'	: '你正在删除一个居民，确定要删除吗?',
					'buttons'	: {
						'确定'	: {
							'class'	: 'blue',
							'action': function(){
								window.location.href='LogoutResident?rsid=' + rsid;
								elem.slideUp();
							}
						},
						'取消'	: {
							'class'	: 'gray',
							'action': function(){}	// Nothing to do in this case. You can as well omit the action property.
						}
					}
				});
				
			});
});