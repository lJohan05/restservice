package com.sophossolutions.task;

import com.google.gson.Gson;
import com.sophossolutions.utils.Constant;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpHeaders;
import org.eclipse.jetty.http.HttpHeader;

import java.util.HashMap;
import java.util.Map;

public class PostMethod implements Task {

    private String url;
    private String body;

    public PostMethod(String url, String body) {
        this.url = url;
        this.body = body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(url).with(request-> request.header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                .auth().oauth2(Constant.ACCES_TOKEN).body(body)));
    }

    public static String bodyUser(Map<String, String> dataTable) {

        Map<String, String> user = new HashMap<>();
        Gson gson = new Gson();
        user.put("first_name", dataTable.get("first_name"));
        user.put("last_name", dataTable.get("last_name"));
        user.put("gender", dataTable.get("gender"));
        user.put("email", dataTable.get("email"));
        user.put("status", dataTable.get("status"));
        return gson.toJson(user);
    }

    public static PostMethod createUser(String url, String body) {
        return Tasks.instrumented(PostMethod.class, url, body);
    }
}
