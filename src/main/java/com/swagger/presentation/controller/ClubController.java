package com.swagger.presentation.controller;

import com.swagger.presentation.Schema.ErrorResponse;
import com.swagger.presentation.dto.AuthLoginRequest;
import com.swagger.presentation.dto.AuthResponse;
import com.swagger.presentation.dto.ClubDTO;
import com.swagger.service.interfaces.IClubService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/club")
@RequiredArgsConstructor
@Tag(name = "Club", description = "Controller for request club data")
public class ClubController {

    private final IClubService clubService;

    // Find All
    @GetMapping("/findAll")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @Operation(
        summary = "Find all clubs",
        description = "Search all clubs",
        tags = {"Find Clubs"},
        responses = {
            @ApiResponse(
                responseCode = "200", description = "Successful search",
                content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = ClubDTO.class))
                )
            )
        }
    )
    public ResponseEntity<List<ClubDTO>> findAll(){
        return new ResponseEntity<>(this.clubService.findAll(), HttpStatus.OK);
    }

    // Find By Id
    @GetMapping("/find/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @Operation(
        summary = "Find a club",
        description = "Find a club by id",
        tags = {"Find Club"},
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "Successful search",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ClubDTO.class)
                )
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Club not found",
                content =@Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class)
                )  
            )
        }
    )
    public ResponseEntity<?> findById(
        @Parameter(
            description = "ID of the club to be retrieved", 
            example = "1", 
            required = true
        )
        @PathVariable Long id
        ){
            ClubDTO club = this.clubService.findById(id);
            if (club.getId() == null) {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("message", "Club not found");
                errorResponse.put("status", "404");
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(club, HttpStatus.OK);
    }

    // Save
    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation(
        summary = "Save a new club",
        description = "Create a new club",
        tags = {"Save club"},
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Save a new club usign name and country",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ClubDTO.class)
            )
        ),
        responses = {
            @ApiResponse(
                responseCode = "201", description = "Successfully Created!",
                content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = ClubDTO.class))
                )
            ),
            @ApiResponse(
                responseCode = "400", description = "Invalid input data"
            )
        }
    )
    public ResponseEntity<ClubDTO> save(@RequestBody ClubDTO clubDTO){
        return new ResponseEntity<>(this.clubService.save(clubDTO), HttpStatus.CREATED);
    }

    // Update
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation(
        summary = "Update a club",
        description = "Update an existing club by ID",
        tags = {"Update club"},
        parameters = {
            @Parameter(
                name = "id",
                description = "ID of the club to be updated",
                example = "1",
                required = true
            )
        },
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Updated club details",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ClubDTO.class)
            )
        ),
        responses = {
            @ApiResponse(
                responseCode = "200", description = "Successfully updated",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ClubDTO.class)
                )
            ),
            @ApiResponse(
                responseCode = "404", description = "Club not found"
            ),
            @ApiResponse(
                responseCode = "400", description = "Invalid input data"
            )
        }
    )
    public ResponseEntity<ClubDTO> update(
        @PathVariable Long id, 
        @RequestBody ClubDTO clubDTO
    ){
        return new ResponseEntity<>(this.clubService.updateClub(id, clubDTO), HttpStatus.CREATED);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation(
        summary = "Delete a club",
        description = "Delete a club by ID",
        tags = {"Delete club"},
        parameters = {
            @Parameter(
                name = "id",
                description = "ID of the club to be deleted",
                example = "1",
                required = true
            )
        },
        responses = {
            @ApiResponse(
                responseCode = "200", description = "Successfully deleted",
                content = @Content(
                    mediaType = "text/plain",
                    schema = @Schema(example = "Club deleted successfully")
                )
            ),
            @ApiResponse(
                responseCode = "404", description = "Club not found"
            )
        }
    )
    public ResponseEntity<String> delete(@PathVariable Long id){
        return new ResponseEntity<>(this.clubService.deleteClub(id), HttpStatus.OK);
    }
}
