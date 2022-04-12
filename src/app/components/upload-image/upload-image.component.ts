import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-upload-image',
  templateUrl: './upload-image.component.html',
  styleUrls: ['./upload-image.component.css']
})
export class UploadImageComponent implements OnInit {
  constructor(private httpClient: HttpClient) { }
  uploadedImage!: File;  
  dbImage: any; 
  postResponse: any;
  successResponse?: string;
  image: any;

  public onImageUpload(event: any) {    
    this.uploadedImage = event.target.files[0];
  }


  imageUploadAction() {    
    const imageFormData = new FormData();
    imageFormData.append('image', this.uploadedImage, this.uploadedImage.name);
  

    this.httpClient.post('http://localhost:6060/image/upload', imageFormData, { observe: 'response' })
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
    this.httpClient.get('http://localhost:6060/get/info' + this.image)
      .subscribe(
        res => {
          this.postResponse = res;          
          this.dbImage = 'data:image/jpeg;base64,' + this.postResponse.image;
        }
      );
  }
  ngOnInit(): void {
  }

}
