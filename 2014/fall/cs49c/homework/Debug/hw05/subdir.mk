################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../hw05/hw5.c \
../hw05/main.c 

OBJS += \
./hw05/hw5.o \
./hw05/main.o 

C_DEPS += \
./hw05/hw5.d \
./hw05/main.d 


# Each subdirectory must supply rules for building sources it contributes
hw05/%.o: ../hw05/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


