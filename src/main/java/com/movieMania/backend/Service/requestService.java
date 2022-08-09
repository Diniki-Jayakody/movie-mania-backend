package com.movieMania.backend.Service;

import com.movieMania.backend.Entity.request;

import java.util.List;

public interface requestService {

    String addRequest(request request,Long movie);
    List<request> getAllPayableRequest();
    String cancelRequest(String code);
    String addScanCopy(String url,String code);
    List<request> getPayedRequests();
    String confirmRequest(Long id);
    String rejectRequest(Long id,String reason);
    request getByCode(String code);
    String sendUploadMail(String code);
    List<request> getNotPayableRequests();
    String setShowState(Long id);
}
