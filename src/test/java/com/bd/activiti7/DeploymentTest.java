package com.bd.activiti7;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class DeploymentTest {
    @Resource
    private RepositoryService repositoryService;

    //通过bpmn部署流程
    @Test
    public void initDeployment(){
        String fileName = "";
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource(fileName)
                //.addClasspathResource(照片)
                .name("流程部署测试")
                .deploy();
        System.out.println(deployment.getName());
    }

    //查询流程部署
    @Test
    public void getDeployments() {
        List<Deployment> list = repositoryService.createDeploymentQuery().list();
        list.forEach(dep -> {
            System.out.println("Id："+dep.getId());
            System.out.println("Name："+dep.getName());
            System.out.println("DeploymentTime："+dep.getDeploymentTime());
            System.out.println("Key："+dep.getKey());
        });
    }
}
