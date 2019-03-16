//<![CDATA[
    // // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('da37e5836c002230d358ce5af57a57ca');
    // // 카카오링크 버튼을 생성합니다. 처음 한번만 호출하면 됩니다.
    var thisURL = $(location).attr('href');
    function sendLink() {
      Kakao.Link.sendDefault({
        objectType: 'location',
        address: $("#bex2").text(),
        addressTitle: $("#bex1").text(),
        content: {
          title: '☆'+$("#bex1").text()+'☆',
          description: $("#rname").val(),
          imageUrl: 'http://localhost:8080/luna/resources/rooms/cat1.jpg',
          link: {
            mobileWebUrl: 'https://developers.kakao.com',
            webUrl: 'https://developers.kakao.com'
          }
        },
        buttons: [
          {
            title: '웹으로 보기',
            link: {
              mobileWebUrl: thisURL,
              webUrl: thisURL
            }
          }
        ]
      });
    }
  //]]>
    //address,branchName,roomName,roomEx1,img1