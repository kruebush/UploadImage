import { Injectable } from '@angular/core';
import { ImageUtilObj } from '../models/ImageUtilObj';
import { Post } from '../models/Post';
import { PostUtilObj } from '../models/PostUtilObj';
import { ProfileImage } from '../models/ProfileImage';

@Injectable({
  providedIn: 'root'
})
export class NewImageService {

  constructor() { }

  images: Array<ProfileImage> = [];
  imageUtil: Array<ImageUtilObj> = [];
  
}
