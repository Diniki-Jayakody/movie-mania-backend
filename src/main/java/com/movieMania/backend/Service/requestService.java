package com.movieMania.backend.Service;

import com.movieMania.backend.Entity.request;
import org.graalvm.compiler.core.GraalCompiler;

import java.util.List;

public interface requestService {

    String addRequest(request request);
    List<request> getAllRequest();
    String cancelRequest(String code);
    String addScanCopy(String url,String code);
    List<request> getPayedRequests();
    String confirmRequest(Long id);
    String rejectRequest(Long id,String reason);
    request getByCode(String code);
    String sendUploadMail(String code);
}
