package com.aida.service.impl;

import com.aida.config.JwtProvider;
import com.aida.domain.AccountStatus;
import com.aida.domain.USER_ROLE;
import com.aida.model.Address;
import com.aida.model.Seller;
import com.aida.repository.AddressRepository;
import com.aida.repository.SellerRepository;
import com.aida.service.SellerService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final AddressRepository addressRepository;

    public SellerServiceImpl(SellerRepository sellerRepository, JwtProvider jwtProvider, PasswordEncoder passwordEncoder, AddressRepository addressRepository) {
        this.sellerRepository = sellerRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.addressRepository = addressRepository;
    }

    @Override
    public Seller getSellerProfile(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromJwtToken(jwt);
        return this.getSellerByEmail(email);
    }

    @Override
    public Seller createSeller(Seller seller) throws Exception {
        Seller sellerExists = sellerRepository.findByEmail(seller.getEmail());

        if(sellerExists != null){
            throw new Exception("seller with given email already exists");
        }

        Address savedAddress = addressRepository.save(seller.getPickupAddress());

        Seller newSeller = new Seller();
        newSeller.setEmail(seller.getEmail());
        newSeller.setPassword(passwordEncoder.encode(seller.getPassword()));
        newSeller.setSellerName(seller.getSellerName());
        newSeller.setPickupAddress(savedAddress);
        newSeller.setGSTIN(seller.getGSTIN());
        newSeller.setRole(USER_ROLE.ROLE_SELLER);
        newSeller.setMobile(seller.getMobile());
        newSeller.setBankDetails(seller.getBankDetails());
        newSeller.setBusinessDetails(seller.getBusinessDetails());

        return sellerRepository.save(newSeller);
    }

    @Override
    public Seller getSellerById(Long id) throws Exception {
        return sellerRepository.findById(id).orElseThrow(() -> new Exception("seller not found with given id"));
    }

    @Override
    public Seller getSellerByEmail(String email) throws Exception {
        Seller seller = sellerRepository.findByEmail(email);
        if(seller==null) throw new Exception("no seller with given email");
        return seller;
    }

    @Override
    public List<Seller> getAllSellers(AccountStatus status) {
        return sellerRepository.findByAccountStatus(status);
    }

    @Override
    public Seller updateSeller(Long id, Seller seller) throws Exception {
        Seller existingSeller = this.getSellerById(id);

        if(seller.getSellerName() != null){
            existingSeller.setSellerName(seller.getSellerName());
        }

        if(seller.getMobile() != null){
            existingSeller.setMobile(seller.getMobile());
        }

        if(seller.getEmail() != null){
            existingSeller.setEmail(seller.getEmail());
        }

        if(seller.getBusinessDetails() != null && seller.getBusinessDetails().getBusinessName() != null){
            existingSeller.getBusinessDetails().setBusinessName(
                    seller.getBusinessDetails().getBusinessName()
            );
        }














        return null;
    }

    @Override
    public void deleteSeller(Long id) {

    }

    @Override
    public Seller verifyEmail(String email, String otp) {
        return null;
    }

    @Override
    public Seller updateSellerAccountStatus(Long sellerId, AccountStatus status) {
        return null;
    }
}
