package com.codingshuttle.distributed_lovable.account_service.config;

import com.codingshuttle.distributed_lovable.account_service.entity.Plan;
import com.codingshuttle.distributed_lovable.account_service.repository.PlanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedPlans(PlanRepository planRepository) {
        return args -> {

            if (planRepository.count() > 0) {
                return;
            }
           //
            Plan pro = new Plan();
            pro.setName("PRO");
            pro.setStripePriceId("price_1ToZxU9ddI7TTPGG5l5yxmMw"); // Replace with your actual Stripe Price ID
            pro.setMaxProjects(25);
            pro.setMaxTokensPerDay(50000);
            pro.setMaxPreviews(100);
            pro.setUnlimitedAi(false);


            Plan business = new Plan();
            business.setName("BUSINESS");
            business.setStripePriceId("price_1ToZz39ddI7TTPGG8nKqStPH"); // Replace with your actual Stripe Price ID
            business.setMaxProjects(100);
            business.setMaxTokensPerDay(0); // Ignored because unlimitedAi = true
            business.setMaxPreviews(1000);
            business.setUnlimitedAi(true);
            business.setActive(true);

            planRepository.save(pro);
            planRepository.save(business);

            System.out.println("Plans seeded successfully.");
        };
    }
}