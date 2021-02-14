package com.nabzi.mvi.network;

import com.nabzi.mvi.BuildConfig;

import java.io.IOException;
import java.net.URI;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class FakeInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = null;
        if(BuildConfig.DEBUG) {
            String responseString;
            // Get Request URI.
            final URI uri = chain.request().url().uri();
            // Get Query String.
            final String query = uri.getQuery();
            // Parse the Query String.
            final String[] parsedQuery = query.split("=");

            responseString =
                    "[ { \"id\" : 1 , \"title\" : \"A healthy food\", \"desc\" : \"This is A healthy food\" , \"type\" :  \"pizza\", \"imageUrl\" : \"https://cdn.shortpixel.ai/client/q_glossy,ret_img,w_413/https://www.foodiesfeed.com/wp-content/uploads/2019/02/pizza-ready-for-baking-413x275.jpg\", \"price\" : 100.0 }]";


//            {
//                "id" : 2 ,
//                    "title" : "A great food",
//                    "desc" : "This is A great food" ,
//                    "type" :  "pizza",
//                    "imageUrl" : "https://cdn.shortpixel.ai/client/q_glossy,ret_img,w_413/https://www.foodiesfeed.com/wp-content/uploads/2019/06/beautiful-vibrant-shot-of-traditional-korean-meals-413x275.jpg",
//                    "price" : 200.0
//            },
//            {
//                "id" : 3 ,
//                    "title" : "A fatty food",
//                    "desc" : "This is A fatty food" ,
//                    "type" :  "pizza",
//                    "imageUrl" : "https://cdn.shortpixel.ai/client/q_glossy,ret_img,w_413/https://www.foodiesfeed.com/wp-content/uploads/2019/04/mae-mu-fried-rice-413x330.jpg",
//                    "price" : 300.0
//            },
//            {
//                "id" : 4 ,
//                    "title" : "A yummy food",
//                    "desc" : "This is A yummy food" ,
//                    "type" :  "pizza",
//                    "imageUrl" : "https://cdn.shortpixel.ai/client/q_glossy,ret_img,w_413/https://www.foodiesfeed.com/wp-content/uploads/2019/07/neapolitan-pizza-margherita-413x275.jpg",
//                    "price" : 400.0
//            }
//        ]
            response = new Response.Builder()
                    .code(200)
                    .message(responseString)
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_0)
                    .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                    .addHeader("content-type", "application/json")
                    .build();
        }
        else {
            response = chain.proceed(chain.request());
        }

        return response;
    }

}
