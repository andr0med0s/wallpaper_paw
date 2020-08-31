
 // Your web app's Firebase configuration
 var firebaseConfig = {
  apiKey: "AIzaSyAV0r7WFOg_BdWNrP5FUK9ApdBWPOKXrGM",
  authDomain: "my-wallpaper-app-4132b.firebaseapp.com",
  databaseURL: "https://my-wallpaper-app-4132b.firebaseio.com",
  projectId: "my-wallpaper-app-4132b",
  storageBucket: "my-wallpaper-app-4132b.appspot.com",
  messagingSenderId: "118033404114",
  appId: "1:118033404114:web:94e5570200bf539a7c5d0b",
  measurementId: "G-MV1C51YCX3"
};
  // Initialize Firebase
 firebase.initializeApp(firebaseConfig);

 firebase.auth.Auth.Persistence.LOCAL;


 $("#btn-login").click(function(){        
  var email = $("#email").val();
  var password = $("#password").val(); 

  var result = firebase.auth().signInWithEmailAndPassword(email, password);
  
  result.catch(function(error){
      var errorCode = error.code; 
      var errorMessage = error.message; 

      console.log(errorCode);
      console.log(errorMessage);
  });
});

$("#btn-logout").click(function(){
  firebase.auth().signOut();
});

function switchView(view){
    $.get({
      url: view,
      cache: false,
    }).then(function(data){
      $("#container").html(data);
    });
  }
 

