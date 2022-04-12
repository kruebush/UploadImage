import { Byte } from "@angular/compiler/src/util";
import { Type } from "@angular/core";
import { User } from "./User";

//Model for Image to upload profile pic
export class ProfileImage {

    imageId: number;
    creatorId: User;
    contentType: string;
    picByte: Byte;


    constructor(
        creatorId: User, 
        contentType?: string,
        picByte?: Byte,
        imageId?: number,

    ) {
        this.imageId = imageId
        this.creatorId = creatorId
        this.contentType= contentType
        this.picByte= picByte
    
      }

}