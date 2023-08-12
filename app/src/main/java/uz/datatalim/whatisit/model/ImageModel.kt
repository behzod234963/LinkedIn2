package uz.datatalim.whatisit.model

data class ImageModel(val profile:Int,
                      val username:String,
                      val title:String,
                      val post:String,
                      val postImage:Int?,
                      val likes:String,
                      val comments:String,
                      val follow:Boolean=false,
                      val isLiked:Boolean=false)
