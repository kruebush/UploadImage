import { HttpClient } from '@angular/common/http';
import { Byte } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { By } from '@angular/platform-browser';
import { ImageUtilObj } from 'src/app/models/ImageUtilObj';
import { ProfileImage } from 'src/app/models/ProfileImage';
import { User } from 'src/app/models/User';
import { ImageService } from 'src/app/services/image.service';
import { LoginService } from 'src/app/services/login.service';
import { NewImageService } from 'src/app/services/new-image.service '; 
import { PostHttpServiceService } from 'src/app/services/post-http-service.service';

@Component({
  selector: 'app-profile-image',
  templateUrl: './profile-image.component.html',
  styleUrls: ['./profile-image.component.css']
})
export class ProfileImageComponent implements OnInit {
  constructor(private httpClient: HttpClient) { }

  uploadedImage!: File;  
  dbImage: any; 
  postResponse: any;
  successResponse?: string;
  image: any;

  public onImageUpload(event: any) {    
    this.uploadedImage = event.target.files[0];
  }


  ngOnInit(): void {
  }
 //CODE TO UPLOADING PROFILE IMAGE 
 imageUploadAction() {    
  const imageFormData = new FormData();
  imageFormData.append('image', this.uploadedImage, this.uploadedImage.name);


  this.httpClient.post('http://localhost:9001/image/upload', imageFormData, { observe: 'response' })
    .subscribe((response) => {
      if (response.status === 200) { 
        this.postResponse = response;                
        this.successResponse = this.postResponse.body.message;
      } else {
        this.successResponse = 'Image not uploaded due to some error!';
      }
    }
    );
  }

viewImage() {
this.httpClient.get('http://localhost:9001/get/info' + this.image)
.subscribe(
  res => {
    this.postResponse = res;          
    this.dbImage = 'data:image/jpeg;base64,' + this.postResponse.image;
  }
);
}
}


//   constructor(private loginService: LoginService, private http: HttpClient, private imageService:ImageService, private postService: PostHttpServiceService, private newImageService: NewImageService) { }
//   urlLink:string;
//   creatorId:User;
//   picByte: Byte;
//   body: string;

//   user: User = this.loginService.getLoginInfo().user;
//   // user: User = new User(1,'email','first','last',10000000,19,'gitur','title','NY','aboutme');
//   //post = new Post(this.user,'body','image',1637264203, false);
//   image = new ProfileImage(this.user,'contentType');
  

//   //NGIFs
//   expandThis=false;
//   show=false;

  
//   ngOnInit(): void {
//   }

//   expand(){
//     this.expandThis=true;
//   }

//   //CODE FOR IMGBB
//   onInput(e: Event){
//     const input = e.target as HTMLInputElement;
//     this.imageService.uploadProfile(input.files[0])
//     .subscribe(url => {
//       console.log(url);
//       this.urlLink = url;
//     });

//     //CODE TO DISPLAY IMAGE AS CLICKED
//     if(input.files[0]){
//         var reader = new FileReader();
//         reader.readAsDataURL(input.files[0])
//         reader.onload = (input:any) =>{
//           this.urlLink = input.result
//           this.show=true;
//         }
//       }
//   }

//   //ADDING POST
//   uploadProfile(){
//     console.log();
//     this.image ={
//     creatorId: this.user,
//     contentType: this.urlLink,
//     picByte:  this.picByte,
//     imageId:0
    
//     }
//     //CALLING UPLOAD SERVICE TO SEND NEW PIC
//     this.postService.addImage(this.image)
//    .subscribe(data =>{
//      console.log(data);
//      this.image.imageId = data.imageId;

//      let newImage = new ProfileImage(this.user, this.urlLink, this.picByte,0);
//      newImage.imageId = this.image.imageId;

//      console.log(this.newImageService.images );
     
//      this.newImageService.imageUtil.push(new ImageUtilObj(newImage.imageId));
//      this.newImageService.images.unshift(newImage);
 
//      console.log(this.newImageService.images);
 
//      this.body="";
//      this.show=false;
//      this.expandThis=false;

//     }, error=> console.log(error));


//   //   //CALLING ADD POST SERVICE TO SEND NEW POST
//   //   this.postService.addPost(this.post)
//   //  .subscribe(data =>{
//   //    console.log(data);
//   //    this.post.postId = data.postId;

//   //    let newPost = new Post(this.user, this.body, this.urlLink, this.post.date, false, null, 0);
//   //    newPost.postId = this.post.postId;

//   //    console.log(this.newPostService.posts);
     
//   //    this.newPostService.postUtil.push(new PostUtilObj(newPost.postId, 0, ""));
//   //    this.newPostService.posts.unshift(newPost);
 
//   //    console.log(this.newPostService.posts);
 

//   //    this.show=false;
//   //    this.expandThis=false;

//   //   }, error=> console.log(error));

//     // window.location.reload();

    
//   }


// }
//   //FIRST WAY OF IMAGE INPUT
// //   constructor (private httpClient: HttpClient){ }

// //   selectedFile: File;
// //   retrievedImage: any;
// //   base64Data: any;
// //   retrieveResonse: any;
// //   message: string;
// //   imageName: any;

// //   //Gets called when the user selects an image
// //   public onFileChanged(event) {
// //     //Select File
// //     this.selectedFile = event.target.files[0];
// //   }
// //   //Gets called when the user clicks on submit to upload the image
// //   onUpload() {
// //     console.log(this.selectedFile);
    

    
// //     //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
// //     const uploadImageData = new FormData();
// //     uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);
  
// //     //Make a call to the Spring Boot Application to save the image
// //     this.httpClient.post('http://localhost:9001/image/upload', uploadImageData, { observe: 'response' })
// //       .subscribe((response) => {
// //         if (response.status === 200) {
// //           this.message = 'Image uploaded successfully';
// //         } else {
// //           this.message = 'Image not uploaded successfully';
// //         }
// //       }
// //       );
// //   }
// //     //Gets called when the user clicks on retieve image button to get the image from back end
// //     getImage() {
// //     //Make a call to Sprinf Boot to get the Image Bytes.
// //     this.httpClient.get('http://localhost:9001/image/get/' + this.imageName)
// //       .subscribe(
// //         res => {
// //           this.retrieveResonse = res;
// //           this.base64Data = this.retrieveResonse.picByte;
// //           this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
// //         }
// //       );
// //   }
// //   ngOnInit(): void {
    
// //   }
// // }

