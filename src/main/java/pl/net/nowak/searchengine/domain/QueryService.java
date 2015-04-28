package pl.net.nowak.searchengine.domain;

import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.net.nowak.searchengine.api.dto.QueryResultDTO;
import pl.net.nowak.searchengine.domain.eniro.EniroAPIClient;
import pl.net.nowak.searchengine.domain.eniro.EniroURLFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/**
 * Author: Maciek
 */
@Component
public class QueryService {


    @Inject TaskExecutor taskExecutor;
    @Inject
    EniroURLFactory urlFactory;
    @Inject QueryResultFactory resultFactory;

    private Logger log = Logger.getLogger(this.getClass().getCanonicalName());

    public List<QueryResultDTO> search(String... queries) throws InterruptedException {

        List<QueryResultDTO> retList = new ArrayList<>();

        List<GetRequestTask> tasks = new ArrayList<>();
        for (String query : queries) {
            tasks.add(new GetRequestTask(urlFactory.getURL(query), this.taskExecutor));
        }

        while(!tasks.isEmpty()) {
            for(Iterator<GetRequestTask> it = tasks.iterator(); it.hasNext();) {
                GetRequestTask task = it.next();
                if(task.isDone()) {
                    ResponseEntity<String> response = task.getResponse();
                    retList.addAll(parseResponse(response));
                    it.remove();
                }
            }
            if(!tasks.isEmpty()) Thread.sleep(100);
        }

        return retList;
    }


    private List<QueryResultDTO> parseResponse(ResponseEntity<String> response) {
        if(response.getStatusCode() == HttpStatus.OK) {
            try {
                return resultFactory.parseJSON(response.getBody());
            } catch (Exception e) {
                log.error(e.getMessage(),e);
                return new ArrayList<>();
            }
        }else {
            return new ArrayList<>();
        }
    }


    private class GetRequestTask {
        private EniroAPIClient work;
        private FutureTask<ResponseEntity<String>> task;
        public GetRequestTask(String url, Executor executor) {
            this.work = new EniroAPIClient(url);
            this.task = new FutureTask<>(work);
            executor.execute(this.task);
        }

        public boolean isDone() {
            return this.task.isDone();
        }
        public ResponseEntity<String> getResponse() {
            try {
                return this.task.get();
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }




}
