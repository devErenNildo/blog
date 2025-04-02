package com.eren.dev.post.create;

import com.eren.dev.UseCaseTest;
import com.eren.dev.post.PostGateway;
import com.eren.dev.utils.data.factory.PostDataFactory;
import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class CreatePostUseCaseTest extends UseCaseTest {

    private static Faker faker = new Faker(new Locale("PT-BR"));

    @InjectMocks
    private DefaultCreatePostUseCase useCase;

    @Mock
    private PostGateway postGateway;

    @Override
    protected List<Object> getMocks() {
        return List.of(postGateway);
    }

    @Test
    public void givenAValidCommand_whenCallsCreatePost_shouldReturnCategoryId(){

        final var expectedTitle = faker.book().title();
        final var expectedContent = faker.lorem().paragraph();
        final var expectedIsActive = true;
        final var expectedAuthor = faker.name().fullName();

        final var aCommand =
                CreatePostCommand.with(expectedTitle, expectedContent, expectedIsActive, expectedAuthor);

        when(postGateway.create(any()))
                .thenAnswer(returnsFirstArg());

        final var result = useCase.execute(aCommand);

        Assertions.assertTrue(result.isRight());

        final var actualOutput= result.getRight();

        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput.id());

        Mockito.verify(postGateway, times(1)).create(argThat(aPost ->
                Objects.equals(expectedTitle, aPost.getTitle())
                    && Objects.equals(expectedContent, aPost.getContent())
                    && Objects.equals(expectedIsActive, aPost.isActive())
                    && Objects.equals(expectedAuthor, aPost.getAuthor())
                    && Objects.nonNull(aPost.getId())
                    && Objects.nonNull(aPost.getCreatedAt())
                    && Objects.nonNull(aPost.getUpdatedAt())
                    && Objects.isNull(aPost.getDeletedAt())
        ));
    }
}
