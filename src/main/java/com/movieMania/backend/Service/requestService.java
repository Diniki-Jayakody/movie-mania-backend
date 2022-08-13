package com.movieMania.backend.Service;

import com.movieMania.backend.Entity.request;
import com.movieMania.backend.Entity.requestResponse;

import java.util.List;

public interface requestService {

    String addRequest(request request,Long movie);
    List<requestResponse> getAllPayableRequest();
    String cancelRequest(String code);
    String addScanCopy(String url,String code);
    List<requestResponse> getPayedRequests();
    String confirmRequest(Long id);
    String rejectRequest(Long id,String reason);
    request getByCode(String code);
    String sendUploadMail(String code);
    List<requestResponse> getNotPayableRequests();
    String setShowState(Long id);
}
