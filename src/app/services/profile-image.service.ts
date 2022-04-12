import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";

@Injectable({
    providedIn: 'root'
  })
  export class ImageService {
  
    uploadedImage!: File;  
    dbImage: any; 
    postResponse: any;
    successResponse?: string;
    image: any;
    
    //CODE FOR IMGBB 
    private apiKey: string = '54a88bf42f4fe7281b1ba9ba2c242ecb';
  
  
    constructor(private http:HttpClient) { }
   
   //CODE FOR IMGBB UPLOAD FOR POST
   upload(file: File): Observable<string>{
     const formData = new FormData();
     formData.append('image', file);
     return this.http.post<any>('https://api.imgbb.com/1/upload', formData, {params: {key:this.apiKey}})
    // .pipe(map((response)=>response['data']['url']));      

   }
   
   uploadProfile(file: File): Observable<string>{
    const formData = new FormData();
    formData.append('image', file);
    return this.http.post<any>('https://localhost:9001/images/upload', formData)
    .pipe(map((response)=>response['data']['url']));      
  }
    
  //CODE TO UPLOADING PROFILE IMAGE 
  imageUploadAction() {    
    const imageFormData = new FormData();
    imageFormData.append('image', this.uploadedImage, this.uploadedImage.name);
  

    this.http.post('http://localhost:9001/image/upload', imageFormData, { observe: 'response' })
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
this.http.get('http://localhost:6060/get/info' + this.image)
  .subscribe(
    res => {
      this.postResponse = res;          
      this.dbImage = 'data:image/jpeg;base64,' + this.postResponse.image;
    }
  );
}
  }
  