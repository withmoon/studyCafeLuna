/**
 * 
 */
//카카오 로그인시 실행될 함수 
function k_logout(){
  		Kakao.Auth.logout();
  		Kakao.cleanup();
  		alert("로그아웃");
}